package com.example.buyhouse.controller;

import com.example.buyhouse.entity.*;
import com.example.buyhouse.service.FangyuanxinxiService;
import com.example.buyhouse.service.ShoucangService;
import com.example.buyhouse.util.jwttoken;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置文件(Shoucang)表控制层
 *
 * @author makejava
 * @since 2023-05-11 21:10:24
 */
@RestController
@RequestMapping("shoucang")
public class ShoucangController {
    /**
     * 服务对象
     */
    @Resource
    private ShoucangService shoucangService;

    @Resource
    private FangyuanxinxiService fangyuanxinxiService;

    /**
     * 分页查询
     *
     * @param shoucang    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Shoucang>> queryByPage(Shoucang shoucang, PageRequest pageRequest) {
        return ResponseEntity.ok(this.shoucangService.queryByPage(shoucang, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Shoucang> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.shoucangService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param shoucang 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Shoucang> add(Shoucang shoucang) {
        return ResponseEntity.ok(this.shoucangService.insert(shoucang));
    }

    /**
     * 编辑数据
     *
     * @param shoucang 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Shoucang> edit(Shoucang shoucang) {
        return ResponseEntity.ok(this.shoucangService.update(shoucang));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.shoucangService.deleteById(id));
    }


    @RequestMapping("/shoucangid")
    public Mapfenzhaung createuser(@RequestBody Shoucang shoucang, @RequestHeader(value = "token") String token) {
        System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if (claims != null) {
            String openid1 = claims.getId();
            System.out.println(openid1);
            String shooucxinxi = shoucang.toString();
            System.out.println(shooucxinxi);

            List<Shoucang> shoucangs = shoucangService.findvaule(shoucang.getId(), openid1);
            if (shoucangs.isEmpty()) {
                Shoucang shoucang1 = new Shoucang();
                shoucang1.setId(shoucang.getId());
                shoucang1.setValue(shoucang.getValue());
                shoucang1.setOpid(openid1);
                System.out.println(shoucang1.toString());
                shoucangService.insert(shoucang1);
                System.out.println("charucg");
            } else {
                System.out.println(shoucangs.toString());
                System.out.println("update");

                Shoucang shoucang2 = new Shoucang();
                shoucang2.setId(shoucang.getId());
                shoucang2.setValue(shoucang.getValue());
                shoucang2.setOpid(openid1);
                //System.out.println(shoucang1.toString());
                shoucangService.updatevalue(shoucang2);
                //System.out.println("update");
            }
        }
        return Mapfenzhaung.ok();
    }

    @RequestMapping("/lishijilu")
    public List lishijilu(@RequestHeader(value = "token") String token) {
        System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if (claims != null) {
            String openid2 = claims.getId();
            System.out.println(openid2);
            List<Fangyuanxinxi> lsfyxx = fangyuanxinxiService.fangyuanxinxiBylsopid(openid2);
            return lsfyxx;
        }
        return null;
    }

    @RequestMapping("/qingkonglishijilu")
    public List qingkonglishijilu(@RequestHeader(value = "token") String token) {
        //System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if (claims != null) {
            String openid2 = claims.getId();
            System.out.println(openid2);

            shoucangService.deleteByopid(openid2);
        }
        return null;
    }


    @RequestMapping("/shoucangjilu")
    public List shoucangjilu(@RequestHeader(value = "token") String token) {
        //System.out.println(token);
        Claims claims = jwttoken.validateJWT(token).getClaims();
        if (claims != null) {
            String openid2 = claims.getId();
            System.out.println(openid2);
            List<Fangyuanxinxi> scfyxx = fangyuanxinxiService.fangyuanxinxiByscopid(openid2);
            return scfyxx;
        }
        return null;
    }


    @RequestMapping(value="/scforvue")
    public Mapfenzhaung scforvue(@RequestBody PageBean pageBean) throws IOException{

        String query=pageBean.getQuery().trim();

        List<Shoucang> shoucangs = shoucangService.getpage(pageBean.getPageNum(), pageBean.getPageSize(),query);

        PageInfo<Shoucang> pageInfo = new PageInfo<>(shoucangs);
        System.out.println("*111111111111***");
        System.out.println(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("shoucangList",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println("*************************");
        return Mapfenzhaung.ok(map);
    }

}

