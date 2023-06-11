package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Openid;
import com.example.buyhouse.dao.OpenidDao;
import com.example.buyhouse.service.OpenidService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户识别信息(Openid)表服务实现类
 *
 * @author makejava
 * @since 2023-05-01 15:08:24
 */
@Service("openidService")
public class OpenidServiceImpl implements OpenidService {
    @Resource
    private OpenidDao openidDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Openid queryById(Long id) {
        return this.openidDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param openid 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Openid> queryByPage(Openid openid, PageRequest pageRequest) {
        long total = this.openidDao.count(openid);
        return new PageImpl<>(this.openidDao.queryAllByLimit(openid, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param openid 实例对象
     * @return 实例对象
     */
    @Override
    public Openid insert(Openid openid) {
        this.openidDao.insert(openid);
        return openid;
    }

    /**
     * 修改数据
     *
     * @param openid 实例对象
     * @return 实例对象
     */
    @Override
    public Openid update(Openid openid) {
        this.openidDao.update(openid);
        return this.queryById(openid.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.openidDao.deleteById(id) > 0;
    }

    @Override
    public List<Openid> openid() {
        List<Openid> openids = openidDao.openid();
        return openids;


    }

    @Override
    public List<Openid> searByOpenid(String realopenid) {
        List<Openid> openids = openidDao.searchByOpenid(realopenid);
        return openids;
    }

    @Override
    public Openid updatebyopenid(Openid newopenida) {
        this.openidDao.updatebyopenid(newopenida);
        return this.queryById(newopenida.getId());

    }

    @Override
    public List<Openid> getpage(int pageNum, int pageSize, String query) {
        PageHelper.startPage(pageNum,pageSize);
        List<Openid> userList = openidDao.getpage(query);
        return userList;

    }


}
