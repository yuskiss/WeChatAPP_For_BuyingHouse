package com.example.buyhouse.service;

import com.example.buyhouse.entity.Openid;
import com.example.buyhouse.entity.Shoufangdingdan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 售房订单(Shoufangdingdan)表服务接口
 *
 * @author makejava
 * @since 2023-05-20 15:02:54
 */
public interface ShoufangdingdanService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shoufangdingdan queryById(Long id);

    /**
     * 分页查询
     *
     * @param shoufangdingdan 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Shoufangdingdan> queryByPage(Shoufangdingdan shoufangdingdan, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param shoufangdingdan 实例对象
     * @return 实例对象
     */
    Shoufangdingdan insert(Shoufangdingdan shoufangdingdan);

    /**
     * 修改数据
     *
     * @param shoufangdingdan 实例对象
     * @return 实例对象
     */
    Shoufangdingdan update(Shoufangdingdan shoufangdingdan);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    List<Shoufangdingdan> getpage(int pageNum, int pageSize, String query);

    void updateIspayByid(Shoufangdingdan shoufangdingdan);

    void deleteByopidandid(String openid1, Long id);

    List<Shoufangdingdan> findall();
}
