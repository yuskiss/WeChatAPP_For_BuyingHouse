package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Config;
import com.example.buyhouse.dao.ConfigDao;
import com.example.buyhouse.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置文件(Config)表服务实现类
 *
 * @author makejava
 * @since 2023-04-25 22:00:43
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigDao configDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Config queryById(Long id) {
        return this.configDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Config> queryByPage(Config config, PageRequest pageRequest) {
        long total = this.configDao.count(config);
        return new PageImpl<>(this.configDao.queryAllByLimit(config, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insert(Config config) {
        this.configDao.insert(config);
        return config;
    }

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config update(Config config) {
        this.configDao.update(config);
        return this.queryById(config.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.configDao.deleteById(id) > 0;
    }

    @Override
    public List<Config> configByType(String type) {
        List<Config> configs = configDao.configByType(type);
        return configs;
    }
}
