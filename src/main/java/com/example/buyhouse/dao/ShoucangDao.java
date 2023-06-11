package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Shoucang;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 配置文件(Shoucang)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-11 22:11:48
 */
public interface ShoucangDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shoucang queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param shoucang 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Shoucang> queryAllByLimit(Shoucang shoucang, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shoucang 查询条件
     * @return 总行数
     */
    long count(Shoucang shoucang);

    /**
     * 新增数据
     *
     * @param shoucang 实例对象
     * @return 影响行数
     */
    int insert(Shoucang shoucang);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoucang> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shoucang> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shoucang> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Shoucang> entities);

    /**
     * 修改数据
     *
     * @param shoucang 实例对象
     * @return 影响行数
     */
    int update(Shoucang shoucang);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    List<Shoucang> findvaule(Long id, String openid1);

    void updatevalue(Shoucang shoucang2);

    void deleteByopid(String openid2);

    List<Shoucang> getpage(String query);
}

