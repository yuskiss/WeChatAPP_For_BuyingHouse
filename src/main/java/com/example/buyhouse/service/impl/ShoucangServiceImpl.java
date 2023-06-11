package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Openid;
import com.example.buyhouse.entity.Shoucang;
import com.example.buyhouse.dao.ShoucangDao;
import com.example.buyhouse.service.ShoucangService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置文件(Shoucang)表服务实现类
 *
 * @author makejava
 * @since 2023-05-11 21:10:24
 */
@Service("shoucangService")
public class ShoucangServiceImpl implements ShoucangService {
    @Resource
    private ShoucangDao shoucangDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Shoucang queryById(Long id) {
        return this.shoucangDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param shoucang 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Shoucang> queryByPage(Shoucang shoucang, PageRequest pageRequest) {
        long total = this.shoucangDao.count(shoucang);
        return new PageImpl<>(this.shoucangDao.queryAllByLimit(shoucang, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shoucang 实例对象
     * @return 实例对象
     */
    @Override
    public Shoucang insert(Shoucang shoucang) {
        this.shoucangDao.insert(shoucang);
        return shoucang;
    }

    /**
     * 修改数据
     *
     * @param shoucang 实例对象
     * @return 实例对象
     */
    @Override
    public Shoucang update(Shoucang shoucang) {
        this.shoucangDao.update(shoucang);
        return this.queryById(shoucang.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shoucangDao.deleteById(id) > 0;
    }

    @Override
    public List<Shoucang> findvaule(Long id, String openid1) {
        List<Shoucang> shoucangs = shoucangDao.findvaule(id,openid1);
        return shoucangs;
    }

    @Override
    public void updatevalue(Shoucang shoucang2) {
        this.shoucangDao.updatevalue(shoucang2);

    }

    @Override
    public void deleteByopid(String openid2) {
        this.shoucangDao.deleteByopid(openid2);
    }

    @Override
    public List<Shoucang> getpage(int pageNum, int pageSize, String query) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shoucang> shoucangList = shoucangDao.getpage(query);
        return shoucangList;
    }


}
