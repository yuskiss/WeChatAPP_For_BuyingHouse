package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Config;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 配置文件(Config)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-25 22:00:41
 */
public interface ConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param config 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Config> queryAllByLimit(Config config, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param config 查询条件
     * @return 总行数
     */
    long count(Config config);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int insert(Config config);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Config> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Config> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Config> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Config> entities);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Config> configByType(String type);
}



