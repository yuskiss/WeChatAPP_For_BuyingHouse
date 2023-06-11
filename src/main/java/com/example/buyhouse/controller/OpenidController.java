package com.example.buyhouse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.buyhouse.entity.Mapfenzhaung;
import com.example.buyhouse.entity.Openid;
import com.example.buyhouse.entity.PageBean;
import com.example.buyhouse.entity.Token;
import com.example.buyhouse.properties.wxproperties;
import com.example.buyhouse.service.OpenidService;
import com.example.buyhouse.service.TokenService;
import com.example.buyhouse.util.HttpClientUtil;
import com.example.buyhouse.util.SystemConstant;
import com.example.buyhouse.util.jwttoken;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户识别信息(Openid)表控制层
 *
 * @author makejava
 * @since 2023-05-01 15:08:23
 */
@RestController
@RequestMapping("openid")
public class OpenidController {
    /**
     * 服务对象
     */
    @Resource
    private OpenidService openidService;
    @Resource
    private TokenService tokenService;

    /**
     * 分页查询
     *
     * @param openid 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Openid>> queryByPage(Openid openid, PageRequest pageRequest) {
        return ResponseEntity.ok(this.openidService.queryByPage(openid, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Openid> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.openidService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param openid 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Openid> add(Openid openid) {
        return ResponseEntity.ok(this.openidService.insert(openid));
    }

    /**
     * 编辑数据
     *
     * @param openid 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Openid> edit(Openid openid) {
        return ResponseEntity.ok(this.openidService.update(openid));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.openidService.deleteById(id));
    }

    /**
     * 查询openID以及token全部信息
     * @return
     */
    @RequestMapping("/id")
    public List<Openid> openids(){
        List<Openid> openids = openidService.openid();
        return openids;
    }

    @Autowired
    private wxproperties wxproperties;
    @Autowired
    private HttpClientUtil httpClientUtil;

    @RequestMapping(value="/wxlogin")
    public Mapfenzhaung wxlogin(@RequestBody Openid wxopenid) throws IOException {
        String openid = wxopenid.toString();
        System.out.println(openid);

        String jscode2sessionUrl=wxproperties.getJscode2sessionUrl()+"?appid="+wxproperties.getAppid()+"&secret="+wxproperties.getSecret()+"&js_code="+wxopenid.getCode()+"&grant_type=authorization_code";
        System.out.println(jscode2sessionUrl);

        String httpresult = httpClientUtil.sendHttpGet(jscode2sessionUrl);
        System.out.println(httpresult);

        JSONObject jsonObject= JSON.parseObject(httpresult);//转化json串为bean
        String realopenid = jsonObject.get("openid").toString();
        System.out.println(realopenid);

        //判断openID表有没有此openid
        List<Openid> searchopenid = openidService.searByOpenid(realopenid);
        if(searchopenid.isEmpty()){
            System.out.println("wu");//没有就插入
            Openid newopenid = new Openid();
            newopenid.setUopenid(realopenid);
            newopenid.setAvatarurl(wxopenid.getAvatarurl());
            newopenid.setCode(wxopenid.getCode());
            newopenid.setNickname(wxopenid.getNickname());
            System.out.println("想插入的newopenid"+newopenid.toString());
            openidService.insert(newopenid);
            System.out.println("保存openID成功");
            Token newtoken = new Token();
            newtoken.setUserid(realopenid);
            newtoken.setAddtime(new Date());
            newtoken.setExpiratedtime(new Date());
            tokenService.insert(newtoken);
            System.out.println("保存openID在token成功");

        }else {
            System.out.println("存在就更新用户信息");//存在就更新用户信息
            Openid newopenida = new Openid();
            newopenida.setAvatarurl(wxopenid.getAvatarurl());
            newopenida.setCode(wxopenid.getCode());
            newopenida.setNickname(wxopenid.getNickname());
            System.out.println("想插入的newopenid"+newopenida.toString());
            openidService.updatebyopenid(newopenida);
            System.out.println("保存openID成功");
            Token newtokena = new Token();
            newtokena.setUserid(realopenid);
            newtokena.setAddtime(new Date());
            newtokena.setExpiratedtime(new Date());
            tokenService.updatebyuserid(newtokena);
            System.out.println("更新openID在token成功");
        }

        //用jwt创建token
        String token = jwttoken.createJWT(realopenid,wxopenid.getNickname(), SystemConstant.JWT_TTL);//24h有效
        Map<String,Object> resultMap=new HashMap<String,Object>();
        resultMap.put("token",token);
        Token newtokenb = new Token();
        newtokenb.setUserid(realopenid);
        newtokenb.setAddtime(new Date());
        newtokenb.setExpiratedtime(new Date());
        newtokenb.setToken(resultMap.values().toString());
        tokenService.updatebyuserid(newtokenb);
        System.out.println(resultMap.values());
        return Mapfenzhaung.ok(resultMap);

    }

    @RequestMapping(value="/vuegetopid")
    public Mapfenzhaung vuegetopid(@RequestBody PageBean pageBean) throws IOException{
        System.out.println("*************************");
        System.out.println(pageBean.toString());
        String query=pageBean.getQuery().trim();
       // PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());

        //com.github.pagehelper.Page<Openid> openidPage =  openidService.getpage(pageBean.getPageNum(),pageBean.getPageSize());

        List<Openid> openidList = openidService.getpage(pageBean.getPageNum(), pageBean.getPageSize(),query);

        PageInfo<Openid> pageInfo = new PageInfo<>(openidList);

        System.out.println(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("userList",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println("*************************");
        return Mapfenzhaung.ok(map);
    }

}

