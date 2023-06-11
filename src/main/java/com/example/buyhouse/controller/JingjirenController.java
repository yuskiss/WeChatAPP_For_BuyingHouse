package com.example.buyhouse.controller;

import com.example.buyhouse.entity.Jingjiren;
import com.example.buyhouse.service.JingjirenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 经纪人(Jingjiren)表控制层
 *
 * @author makejava
 * @since 2023-05-11 18:42:02
 */
@RestController
@RequestMapping("jingjiren")
public class JingjirenController {
    /**
     * 服务对象
     */
    @Resource
    private JingjirenService jingjirenService;

    /**
     * 分页查询
     *
     * @param jingjiren 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Jingjiren>> queryByPage(Jingjiren jingjiren, PageRequest pageRequest) {
        return ResponseEntity.ok(this.jingjirenService.queryByPage(jingjiren, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Jingjiren> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.jingjirenService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param jingjiren 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Jingjiren> add(Jingjiren jingjiren) {
        return ResponseEntity.ok(this.jingjirenService.insert(jingjiren));
    }

    /**
     * 编辑数据
     *
     * @param jingjiren 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Jingjiren> edit(Jingjiren jingjiren) {
        return ResponseEntity.ok(this.jingjirenService.update(jingjiren));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.jingjirenService.deleteById(id));
    }

    @RequestMapping("/allJinjiren")
    public  List<Jingjiren> alljinjiren(){
        List<Jingjiren> alljinjiren = jingjirenService.alljinjiren();
        return alljinjiren;
    }

}

