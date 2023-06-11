package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Openid;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 用户识别信息(Openid)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-01 15:08:24
 */
public interface OpenidDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Openid queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param openid 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Openid> queryAllByLimit(Openid openid, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param openid 查询条件
     * @return 总行数
     */
    long count(Openid openid);

    /**
     * 新增数据
     *
     * @param openid 实例对象
     * @return 影响行数
     */
    int insert(Openid openid);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Openid> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Openid> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Openid> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Openid> entities);

    /**
     * 修改数据
     *
     * @param openid 实例对象
     * @return 影响行数
     */
    int update(Openid openid);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Openid> openid();

    /**
     * 通过openID查找
     * @param realopenid
     * @return
     */
    List<Openid> searchByOpenid(String realopenid);

    int updatebyopenid(Openid newopenida);


    List<Openid> getpage(String query);
}

