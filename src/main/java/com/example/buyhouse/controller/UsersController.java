package com.example.buyhouse.controller;

import com.example.buyhouse.entity.Mapfenzhaung;
import com.example.buyhouse.entity.Siugaimima;
import com.example.buyhouse.entity.Users;
import com.example.buyhouse.service.UsersService;
import com.example.buyhouse.util.StringUtil;
import com.example.buyhouse.util.SystemConstant;
import com.example.buyhouse.util.jwttoken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户表(Users)表控制层
 *
 * @author makejava
 * @since 2023-05-18 15:51:16
 */

@RestController
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Users>> queryByPage(Users users, PageRequest pageRequest) {
        return ResponseEntity.ok(this.usersService.queryByPage(users, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Users> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.usersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Users> add(Users users) {
        return ResponseEntity.ok(this.usersService.insert(users));
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Users> edit(Users users) {
        return ResponseEntity.ok(this.usersService.update(users));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.usersService.deleteById(id));
    }

    @PostMapping("/adminLogin")
    public Mapfenzhaung adminLogin(@RequestBody Users users){
        System.out.println(users.toString());
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        if(users==null){
            return Mapfenzhaung.error();
        }
        if(StringUtil.isEmpty(users.getUsername())){
            return Mapfenzhaung.error("用户名不能位空！");
        }
        if(StringUtil.isEmpty(users.getPassword())){
            return Mapfenzhaung.error("密码不能位空！");
        }
        Users finduser = usersService.getone(users.getUsername());
        System.out.println(finduser);
//        System.out.println("11111111111");
//        System.out.println(finduser.getPassword().trim());
//        System.out.println(users.getPassword());
//        System.out.println(finduser.getPassword().trim().equals(users.getPassword()));
        if(finduser == null){
            return Mapfenzhaung.error("用户名不存在");
        }if(!finduser.getPassword().trim().equals(users.getPassword())){
            return Mapfenzhaung.error("用户名或密码错误");
        }
        String token = jwttoken.createJWT("-1","admin",SystemConstant.JWT_TTL);



        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("token",token);
        return Mapfenzhaung.ok(resultMap);
    }




    @PostMapping("/xiugaimima")
    public Mapfenzhaung xiugaimima(@RequestBody Siugaimima siugaimima){
        System.out.println(siugaimima.toString());
        System.out.println(siugaimima.getUsername());
        System.out.println(siugaimima.getPassword());
        Users users = new Users();
        users.setUsername(siugaimima.getUsername());
        users.setPassword(siugaimima.getNewPassword());
        usersService.updatebyusername(users);
        return Mapfenzhaung.ok();
    }
}

