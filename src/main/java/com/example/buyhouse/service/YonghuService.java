package com.example.buyhouse.service;

import com.example.buyhouse.entity.Yonghu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 用户(Yonghu)表服务接口
 *
 * @author makejava
 * @since 2023-05-03 13:39:18
 */
public interface YonghuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Yonghu queryById(Long id);

    /**
     * 分页查询
     *
     * @param yonghu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Yonghu> queryByPage(Yonghu yonghu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param yonghu 实例对象
     * @return 实例对象
     */
    Yonghu insert(Yonghu yonghu);

    /**
     * 修改数据
     *
     * @param yonghu 实例对象
     * @return 实例对象
     */
    Yonghu update(Yonghu yonghu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Yonghu> searchopenid(String openid);

    Yonghu updatenewuser(Yonghu yonghu2);
}
