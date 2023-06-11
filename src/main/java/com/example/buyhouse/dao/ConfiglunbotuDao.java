package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Configlunbotu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 配置文件(Configlunbotu)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-28 22:55:04
 */
public interface ConfiglunbotuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Configlunbotu queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param configlunbotu 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Configlunbotu> queryAllByLimit(Configlunbotu configlunbotu, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param configlunbotu 查询条件
     * @return 总行数
     */
    long count(Configlunbotu configlunbotu);

    /**
     * 新增数据
     *
     * @param configlunbotu 实例对象
     * @return 影响行数
     */
    int insert(Configlunbotu configlunbotu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Configlunbotu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Configlunbotu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Configlunbotu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Configlunbotu> entities);

    /**
     * 修改数据
     *
     * @param configlunbotu 实例对象
     * @return 影响行数
     */
    int update(Configlunbotu configlunbotu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Configlunbotu> fanglunbotu(String id);
}

