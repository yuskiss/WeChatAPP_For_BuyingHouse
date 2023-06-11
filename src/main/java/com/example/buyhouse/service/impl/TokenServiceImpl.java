package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Token;
import com.example.buyhouse.dao.TokenDao;
import com.example.buyhouse.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * token表(Token)表服务实现类
 *
 * @author makejava
 * @since 2023-05-02 14:28:01
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Resource
    private TokenDao tokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Token queryById(Long id) {
        return this.tokenDao.queryById(id);
    }

    @Override
    public Token queryByUserid(String userid) {
        return this.tokenDao.queryByUserid(userid);
    }

    /**
     * 分页查询
     *
     * @param token 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Token> queryByPage(Token token, PageRequest pageRequest) {
        long total = this.tokenDao.count(token);
        return new PageImpl<>(this.tokenDao.queryAllByLimit(token, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token insert(Token token) {
        this.tokenDao.insert(token);
        return token;
    }

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token update(Token token) {
        this.tokenDao.update(token);
        return this.queryById(token.getId());
    }


    @Override
    public Token updatebyuserid(Token token) {
        this.tokenDao.updatebyuserid(token);
        return this.queryById(token.getId());
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tokenDao.deleteById(id) > 0;
    }
}
