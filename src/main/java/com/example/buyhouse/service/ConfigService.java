package com.example.buyhouse.service;

import com.example.buyhouse.entity.Config;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 配置文件(Config)表服务接口
 *
 * @author makejava
 * @since 2023-04-25 22:00:43
 */
public interface ConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Long id);

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Config> queryByPage(Config config, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config insert(Config config);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Config> configByType(String type);

}
