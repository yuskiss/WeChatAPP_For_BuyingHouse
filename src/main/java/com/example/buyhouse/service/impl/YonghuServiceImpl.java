package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Yonghu;
import com.example.buyhouse.dao.YonghuDao;
import com.example.buyhouse.service.YonghuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户(Yonghu)表服务实现类
 *
 * @author makejava
 * @since 2023-05-03 13:39:18
 */
@Service("yonghuService")
public class YonghuServiceImpl implements YonghuService {
    @Resource
    private YonghuDao yonghuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Yonghu queryById(Long id) {
        return this.yonghuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param yonghu      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Yonghu> queryByPage(Yonghu yonghu, PageRequest pageRequest) {
        long total = this.yonghuDao.count(yonghu);
        return new PageImpl<>(this.yonghuDao.queryAllByLimit(yonghu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param yonghu 实例对象
     * @return 实例对象
     */
    @Override
    public Yonghu insert(Yonghu yonghu) {
        this.yonghuDao.insert(yonghu);
        return yonghu;
    }

    /**
     * 修改数据
     *
     * @param yonghu 实例对象
     * @return 实例对象
     */
    @Override
    public Yonghu update(Yonghu yonghu) {
        this.yonghuDao.update(yonghu);
        return this.queryById(yonghu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.yonghuDao.deleteById(id) > 0;
    }

    @Override
    public List<Yonghu> searchopenid(String openid) {
        List<Yonghu> yonghus = yonghuDao.searchopenid(openid);
        return yonghus;
    }

    @Override
    public Yonghu updatenewuser(Yonghu yonghu2) {
        this.yonghuDao.updatenewuser(yonghu2);
        return this.queryById(yonghu2.getId());
    }


}
