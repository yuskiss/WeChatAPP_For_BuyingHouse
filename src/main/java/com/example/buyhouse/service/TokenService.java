package com.example.buyhouse.service;

import com.example.buyhouse.entity.Token;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * token表(Token)表服务接口
 *
 * @author makejava
 * @since 2023-05-02 14:28:01
 */
public interface TokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Token queryById(Long id);

    Token queryByUserid(String userid);

    /**
     * 分页查询
     *
     * @param token 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Token> queryByPage(Token token, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    Token insert(Token token);

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    Token update(Token token);

    Token updatebyuserid (Token token);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
