package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Configlunbotu;
import com.example.buyhouse.dao.ConfiglunbotuDao;
import com.example.buyhouse.service.ConfiglunbotuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置文件(Configlunbotu)表服务实现类
 *
 * @author makejava
 * @since 2023-04-28 22:55:04
 */
@Service("configlunbotuService")
public class ConfiglunbotuServiceImpl implements ConfiglunbotuService {
    @Resource
    private ConfiglunbotuDao configlunbotuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Configlunbotu queryById(Long id) {
        return this.configlunbotuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param configlunbotu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Configlunbotu> queryByPage(Configlunbotu configlunbotu, PageRequest pageRequest) {
        long total = this.configlunbotuDao.count(configlunbotu);
        return new PageImpl<>(this.configlunbotuDao.queryAllByLimit(configlunbotu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param configlunbotu 实例对象
     * @return 实例对象
     */
    @Override
    public Configlunbotu insert(Configlunbotu configlunbotu) {
        this.configlunbotuDao.insert(configlunbotu);
        return configlunbotu;
    }

    /**
     * 修改数据
     *
     * @param configlunbotu 实例对象
     * @return 实例对象
     */
    @Override
    public Configlunbotu update(Configlunbotu configlunbotu) {
        this.configlunbotuDao.update(configlunbotu);
        return this.queryById(configlunbotu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.configlunbotuDao.deleteById(id) > 0;
    }

    @Override
    public List<Configlunbotu> fanglunbotu(String id) {
        List<Configlunbotu> configlunbotus = configlunbotuDao.fanglunbotu(id);

        return configlunbotus;
    }
}
