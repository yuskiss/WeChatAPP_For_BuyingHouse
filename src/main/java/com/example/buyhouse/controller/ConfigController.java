package com.example.buyhouse.controller;

import com.example.buyhouse.entity.Config;
import com.example.buyhouse.service.ConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置文件(Config)表控制层
 *
 * @author makejava
 * @since 2023-04-25 22:00:40
 */
@RestController
@RequestMapping("config")
public class ConfigController {
    /**
     * 服务对象
     */
    @Resource
    private ConfigService configService;

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Config>> queryByPage(Config config, PageRequest pageRequest) {
        return ResponseEntity.ok(this.configService.queryByPage(config, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Config> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.configService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param config 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Config> add(Config config) {
        return ResponseEntity.ok(this.configService.insert(config));
    }

    /**
     * 编辑数据
     *
     * @param config 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Config> edit(Config config) {
        return ResponseEntity.ok(this.configService.update(config));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.configService.deleteById(id));
    }

    @RequestMapping("/configByType")
    public List<Config> configByType(String type){
        List<Config> configs = configService.configByType(type);
        return configs;
    }
}

