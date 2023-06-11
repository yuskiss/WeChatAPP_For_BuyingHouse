package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Jingjiren;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 经纪人(Jingjiren)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-11 18:42:02
 */
public interface JingjirenDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Jingjiren queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param jingjiren 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Jingjiren> queryAllByLimit(Jingjiren jingjiren, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param jingjiren 查询条件
     * @return 总行数
     */
    long count(Jingjiren jingjiren);

    /**
     * 新增数据
     *
     * @param jingjiren 实例对象
     * @return 影响行数
     */
    int insert(Jingjiren jingjiren);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Jingjiren> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Jingjiren> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Jingjiren> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Jingjiren> entities);

    /**
     * 修改数据
     *
     * @param jingjiren 实例对象
     * @return 影响行数
     */
    int update(Jingjiren jingjiren);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Jingjiren> alljinjiren();
}

