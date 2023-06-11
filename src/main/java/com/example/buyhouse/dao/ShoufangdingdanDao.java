package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Shoufangdingdan;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 售房订单(Shoufangdingdan)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-20 15:02:54
 */
public interface ShoufangdingdanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shoufangdingdan queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param shoufangdingdan 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Shoufangdingdan> queryAllByLimit(Shoufangdingdan shoufangdingdan, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shoufangdingdan 查询条件
     * @return 总行数
     */
    long count(Shoufangdingdan shoufangdingdan);

    /**
     * 新增数据
     *
     * @param shoufangdingdan 实例对象
     * @return 影响行数
     */
    int insert(Shoufangdingdan shoufangdingdan);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoufangdingdan> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shoufangdingdan> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoufangdingdan> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Shoufangdingdan> entities);

    /**
     * 修改数据
     *
     * @param shoufangdingdan 实例对象
     * @return 影响行数
     */
    int update(Shoufangdingdan shoufangdingdan);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Shoufangdingdan> getpage(String query);

    void updateIspayByid(Shoufangdingdan shoufangdingdan);

    void deleteByopidandid(String openid1, Long id);

    List<Shoufangdingdan> findall();
}

