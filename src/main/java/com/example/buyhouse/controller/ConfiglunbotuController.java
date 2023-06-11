package com.example.buyhouse.controller;

import com.example.buyhouse.entity.Configlunbotu;
import com.example.buyhouse.entity.Fangyuanxinxi;
import com.example.buyhouse.service.ConfiglunbotuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置文件(Configlunbotu)表控制层
 *
 * @author makejava
 * @since 2023-04-28 22:55:04
 */
@RestController
@RequestMapping("configlunbotu")
public class ConfiglunbotuController {
    /**
     * 服务对象
     */
    @Resource
    private ConfiglunbotuService configlunbotuService;

    /**
     * 分页查询
     *
     * @param configlunbotu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Configlunbotu>> queryByPage(Configlunbotu configlunbotu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.configlunbotuService.queryByPage(configlunbotu, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Configlunbotu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.configlunbotuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param configlunbotu 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Configlunbotu> add(Configlunbotu configlunbotu) {
        return ResponseEntity.ok(this.configlunbotuService.insert(configlunbotu));
    }

    /**
     * 编辑数据
     *
     * @param configlunbotu 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Configlunbotu> edit(Configlunbotu configlunbotu) {
        return ResponseEntity.ok(this.configlunbotuService.update(configlunbotu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.configlunbotuService.deleteById(id));
    }

    @RequestMapping("/fanglunbotu")
    public List<Configlunbotu> fanglunbotu(String id) {
        List<Configlunbotu> configlunbotus = configlunbotuService.fanglunbotu(id);
        System.out.println("测试git");
        return configlunbotus;
    }

}

