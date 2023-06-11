package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * token表(Token)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-02 14:27:59
 */
public interface TokenDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Token queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param token 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Token> queryAllByLimit(Token token, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param token 查询条件
     * @return 总行数
     */
    long count(Token token);

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 影响行数
     */
    int insert(Token token);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Token> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Token> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Token> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Token> entities);

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 影响行数
     */
    int update(Token token);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Token queryByUserid(String userid);

    /**
     * 通过userID更新token表
     * @param token
     * @return
     */
    int updatebyuserid(Token token);
}

