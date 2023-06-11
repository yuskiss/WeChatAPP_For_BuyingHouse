package com.example.buyhouse.controller;

import com.example.buyhouse.entity.Mapfenzhaung;
import com.example.buyhouse.entity.Yonghu;
import com.example.buyhouse.service.YonghuService;
import com.example.buyhouse.util.jwttoken;
import io.jsonwebtoken.Claims;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户(Yonghu)表控制层
 *
 * @author makejava
 * @since 2023-05-03 13:39:17
 */
@RestController
@RequestMapping("yonghu")
public class YonghuController {
    /**
     * 服务对象
     */
    @Resource
    private YonghuService yonghuService;

    /**
     * 分页查询
     *
     * @param yonghu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Yonghu>> queryByPage(Yonghu yonghu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.yonghuService.queryByPage(yonghu, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Yonghu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.yonghuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param yonghu 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Yonghu> add(Yonghu yonghu) {
        return ResponseEntity.ok(this.yonghuService.insert(yonghu));
    }

    /**
     * 编辑数据
     *
     * @param yonghu 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Yonghu> edit(Yonghu yonghu) {
        return ResponseEntity.ok(this.yonghuService.update(yonghu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.yonghuService.deleteById(id));
    }


    @RequestMapping("/createuser")
    public Mapfenzhaung createuser(@RequestBody Yonghu yonghu,@RequestHeader(value = "token")String token){
        System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if(claims!=null){
            String openid = claims.getId();
            System.out.println(openid);
            String userxinxi = yonghu.toString();
            System.out.println(userxinxi);

            List<Yonghu> yonghus = yonghuService.searchopenid(openid);
            if(yonghus.isEmpty()) {

                Yonghu yonghu1 = new Yonghu();
                yonghu1.setAddtime(new Date());
                yonghu1.setDianziyouxiang(yonghu.getDianziyouxiang());
                yonghu1.setJiatingdizhi(yonghu.getJiatingdizhi());
                yonghu1.setYonghuxingming(yonghu.getYonghuxingming());
                yonghu1.setLianxidianhua(yonghu.getLianxidianhua());
                yonghu1.setNianling(yonghu.getNianling());
                yonghu1.setShenfenzhenghao(yonghu.getShenfenzhenghao());
                yonghu1.setXingbie(yonghu.getXingbie());
                yonghu1.setYonghuzhanghao(openid);
                System.out.println("想插入的newopenid" + yonghu1.toString());

                yonghuService.insert(yonghu1);
            }
            else {
                System.out.println("存在就更新用户信息");
                Yonghu yonghu2 = new Yonghu();
                yonghu2.setAddtime(new Date());
                yonghu2.setDianziyouxiang(yonghu.getDianziyouxiang());
                yonghu2.setJiatingdizhi(yonghu.getJiatingdizhi());
                yonghu2.setYonghuxingming(yonghu.getYonghuxingming());
                yonghu2.setLianxidianhua(yonghu.getLianxidianhua());
                yonghu2.setNianling(yonghu.getNianling());
                yonghu2.setShenfenzhenghao(yonghu.getShenfenzhenghao());
                yonghu2.setXingbie(yonghu.getXingbie());
                yonghu2.setYonghuzhanghao(openid);
                System.out.println("想更新的newopenid" + yonghu2.toString());
                yonghuService.updatenewuser(yonghu2);
            }
        }else {
            return Mapfenzhaung.error();
        }
        return Mapfenzhaung.ok();
    }


    @RequestMapping("/getyonghuxinxi")
    public Mapfenzhaung getyonghuxinxi(@RequestHeader(value = "token")String token) {
        Claims claims = jwttoken.validateJWT(token).getClaims();
        String openid = claims.getId();

        List<Yonghu> yonghus = yonghuService.searchopenid(openid);

        System.out.println(yonghus.get(0).getJiatingdizhi());


        Map<String,Object> resultMap=new HashMap<String,Object>();
        resultMap.put("Dianziyouxiang",yonghus.get(0).getDianziyouxiang());
        resultMap.put("Id",yonghus.get(0).getId());
        resultMap.put("getJiatingdizhi",yonghus.get(0).getJiatingdizhi());
        resultMap.put("Yonghuxingming",yonghus.get(0).getYonghuxingming());
        resultMap.put("Lianxidianhua",yonghus.get(0).getLianxidianhua());
        resultMap.put("Nianling",yonghus.get(0).getNianling());
        resultMap.put("Shenfenzhenghao",yonghus.get(0).getShenfenzhenghao());
        resultMap.put("Xingbie",yonghus.get(0).getXingbie());

        System.out.println(resultMap);

        return Mapfenzhaung.ok(resultMap);
    }

}

