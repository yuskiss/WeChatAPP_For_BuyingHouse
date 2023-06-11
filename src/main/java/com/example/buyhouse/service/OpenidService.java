package com.example.buyhouse.service;

import com.example.buyhouse.entity.Openid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 用户识别信息(Openid)表服务接口
 *
 * @author makejava
 * @since 2023-05-01 15:08:24
 */
public interface OpenidService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Openid queryById(Long id);

    /**
     * 分页查询
     *
     * @param openid 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Openid> queryByPage(Openid openid, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param openid 实例对象
     * @return 实例对象
     */
    Openid insert(Openid openid);

    /**
     * 修改数据
     *
     * @param openid 实例对象
     * @return 实例对象
     */
    Openid update(Openid openid);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Openid> openid();

    /**
     * 查找是否有此openID
     * @param realopenid
     * @return
     */
    List<Openid> searByOpenid(String realopenid);

    Openid updatebyopenid(Openid newopenida);


    List<Openid> getpage(int pageNum, int pageSize, String query);
}
