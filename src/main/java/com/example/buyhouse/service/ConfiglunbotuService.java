package com.example.buyhouse.service;

import com.example.buyhouse.entity.Configlunbotu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 配置文件(Configlunbotu)表服务接口
 *
 * @author makejava
 * @since 2023-04-28 22:55:04
 */
public interface ConfiglunbotuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Configlunbotu queryById(Long id);

    /**
     * 分页查询
     *
     * @param configlunbotu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Configlunbotu> queryByPage(Configlunbotu configlunbotu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param configlunbotu 实例对象
     * @return 实例对象
     */
    Configlunbotu insert(Configlunbotu configlunbotu);

    /**
     * 修改数据
     *
     * @param configlunbotu 实例对象
     * @return 实例对象
     */
    Configlunbotu update(Configlunbotu configlunbotu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Configlunbotu> fanglunbotu(String id);
}
