package com.example.buyhouse.controller;

import com.example.buyhouse.entity.*;
import com.example.buyhouse.service.FangyuanxinxiService;
import com.example.buyhouse.service.ShoufangdingdanService;
import com.example.buyhouse.service.YonghuService;
import com.example.buyhouse.util.jwttoken;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 售房订单(Shoufangdingdan)表控制层
 *
 * @author makejava
 * @since 2023-05-20 15:02:54
 */
@RestController
@RequestMapping("shoufangdingdan")
public class ShoufangdingdanController {
    /**
     * 服务对象
     */
    @Resource
    private ShoufangdingdanService shoufangdingdanService;

    @Resource
    private FangyuanxinxiService fangyuanxinxiService;

    @Resource
    private YonghuService yonghuService;

    /**
     * 分页查询
     *
     * @param shoufangdingdan 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Shoufangdingdan>> queryByPage(Shoufangdingdan shoufangdingdan, PageRequest pageRequest) {
        return ResponseEntity.ok(this.shoufangdingdanService.queryByPage(shoufangdingdan, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Shoufangdingdan> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.shoufangdingdanService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param shoufangdingdan 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Shoufangdingdan> add(Shoufangdingdan shoufangdingdan) {
        return ResponseEntity.ok(this.shoufangdingdanService.insert(shoufangdingdan));
    }

    /**
     * 编辑数据
     *
     * @param shoufangdingdan 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Shoufangdingdan> edit(Shoufangdingdan shoufangdingdan) {
        return ResponseEntity.ok(this.shoufangdingdanService.update(shoufangdingdan));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.shoufangdingdanService.deleteById(id));
    }


    @RequestMapping(value="/dindanxinxi")
    public Mapfenzhaung vuegetopid(@RequestBody PageBean pageBean) throws IOException {
        System.out.println("*************************");
        System.out.println(pageBean.toString());
        String query=pageBean.getQuery().trim();


        List<Shoufangdingdan> shoufangdingdanList = shoufangdingdanService.getpage(pageBean.getPageNum(), pageBean.getPageSize(),query);

        PageInfo<Shoufangdingdan> pageInfo = new PageInfo<>(shoufangdingdanList);

        System.out.println(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("orderList",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println("*************************");
        return Mapfenzhaung.ok(map);
    }

    @RequestMapping(value="/dindanzhuangtai")
    public Mapfenzhaung dindanzhuangtai(@RequestBody Shoufangdingdan shoufangdingdan) throws IOException {
        System.out.println("//////////////////////");
        System.out.println(shoufangdingdan.toString());
        Long id = shoufangdingdan.getId();
        String zhuangtai = shoufangdingdan.getIspay();
        shoufangdingdanService.updateIspayByid(shoufangdingdan);
        return Mapfenzhaung.ok();
    }

    @GetMapping("/dindansanchu/{id}")
    public Mapfenzhaung dindansanchu(@PathVariable(value = "id") Long id){
        System.out.println("````````````````````````");
        System.out.println(id);
        shoufangdingdanService.deleteById(id);
        return Mapfenzhaung.ok();
    }
    @RequestMapping("/quedinyuyue")
    public Mapfenzhaung quedinyuyue(@RequestBody Shoufangdingdan shoufangdingdan,@RequestHeader(value = "token") String token){
        System.out.println("预约");
        System.out.println(shoufangdingdan);

        System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if (claims != null) {
            String openid1 = claims.getId();
            System.out.println(openid1);
            Long id = shoufangdingdan.getId();
            Fangyuanxinxi fangyuanxinxiList = fangyuanxinxiService.queryById(id);
            List<Yonghu> yonghuList = yonghuService.searchopenid(openid1);
            shoufangdingdan.setAddtime(new Date());
            shoufangdingdan.setDingdanbianhao(String.valueOf(System.currentTimeMillis()));
            shoufangdingdan.setFangyuanmingcheng(fangyuanxinxiList.getFangyuanmingcheng()+fangyuanxinxiList.getId().toString());
            shoufangdingdan.setZongjine(fangyuanxinxiList.getZongjine());
            shoufangdingdan.setJingjirenzhanghao(fangyuanxinxiList.getJingjirenzhanghao());
            shoufangdingdan.setJingjirenxingming(fangyuanxinxiList.getJingjirenxingming());
            shoufangdingdan.setYonghuzhanghao(openid1);
            shoufangdingdan.setYonghuxingming(yonghuList.get(0).getYonghuxingming());
            shoufangdingdan.setIspay("拒绝");
            shoufangdingdan.setYonghudianhua(yonghuList.get(0).getLianxidianhua());
            shoufangdingdanService.insert(shoufangdingdan);
            System.out.println("预约成功");
        }
        return Mapfenzhaung.ok();
    }


    @RequestMapping("/quxiaoyuyue")
    public Mapfenzhaung quxiaoyuyue(@RequestBody Shoufangdingdan shoufangdingdan,@RequestHeader(value = "token") String token){
        System.out.println("取消预约");
        System.out.println(shoufangdingdan);
        System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if (claims != null) {
            String openid1 = claims.getId();
            System.out.println(openid1);
            //通过openID以及房源id进行删除预约
            shoufangdingdanService.deleteByopidandid(openid1,shoufangdingdan.getId());
        }
        return Mapfenzhaung.ok();
    }

    @RequestMapping("/yuyuechakan")
    public List<Shoufangdingdan> yuyuechakan(){
        List<Shoufangdingdan> shoufangdingdanList = shoufangdingdanService.findall();
        return shoufangdingdanList;
    }

}

