package com.example.buyhouse.service;

import com.example.buyhouse.entity.Jingjiren;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 经纪人(Jingjiren)表服务接口
 *
 * @author makejava
 * @since 2023-05-11 18:42:02
 */
public interface JingjirenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Jingjiren queryById(Long id);

    /**
     * 分页查询
     *
     * @param jingjiren 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Jingjiren> queryByPage(Jingjiren jingjiren, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param jingjiren 实例对象
     * @return 实例对象
     */
    Jingjiren insert(Jingjiren jingjiren);

    /**
     * 修改数据
     *
     * @param jingjiren 实例对象
     * @return 实例对象
     */
    Jingjiren update(Jingjiren jingjiren);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Jingjiren> alljinjiren();
}
