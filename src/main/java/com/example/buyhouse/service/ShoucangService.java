package com.example.buyhouse.service;

import com.example.buyhouse.entity.Shoucang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 配置文件(Shoucang)表服务接口
 *
 * @author makejava
 * @since 2023-05-11 21:10:24
 */
public interface ShoucangService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shoucang queryById(Long id);

    /**
     * 分页查询
     *
     * @param shoucang 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Shoucang> queryByPage(Shoucang shoucang, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param shoucang 实例对象
     * @return 实例对象
     */
    Shoucang insert(Shoucang shoucang);

    /**
     * 修改数据
     *
     * @param shoucang 实例对象
     * @return 实例对象
     */
    Shoucang update(Shoucang shoucang);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    List<Shoucang> findvaule(Long id, String openid1);

    void updatevalue(Shoucang shoucang2);

    void deleteByopid(String openid2);

    List<Shoucang> getpage(int pageNum, int pageSize, String query);

}
