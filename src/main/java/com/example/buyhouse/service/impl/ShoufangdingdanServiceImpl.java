package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Openid;
import com.example.buyhouse.entity.Shoufangdingdan;
import com.example.buyhouse.dao.ShoufangdingdanDao;
import com.example.buyhouse.service.ShoufangdingdanService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 售房订单(Shoufangdingdan)表服务实现类
 *
 * @author makejava
 * @since 2023-05-20 15:12:24
 */
@Service("shoufangdingdanService")
public class ShoufangdingdanServiceImpl implements ShoufangdingdanService {
    @Resource
    private ShoufangdingdanDao shoufangdingdanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Shoufangdingdan queryById(Long id) {
        return this.shoufangdingdanDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param shoufangdingdan 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Shoufangdingdan> queryByPage(Shoufangdingdan shoufangdingdan, PageRequest pageRequest) {
        long total = this.shoufangdingdanDao.count(shoufangdingdan);
        return new PageImpl<>(this.shoufangdingdanDao.queryAllByLimit(shoufangdingdan, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shoufangdingdan 实例对象
     * @return 实例对象
     */
    @Override
    public Shoufangdingdan insert(Shoufangdingdan shoufangdingdan) {
        this.shoufangdingdanDao.insert(shoufangdingdan);
        return shoufangdingdan;
    }

    /**
     * 修改数据
     *
     * @param shoufangdingdan 实例对象
     * @return 实例对象
     */
    @Override
    public Shoufangdingdan update(Shoufangdingdan shoufangdingdan) {
        this.shoufangdingdanDao.update(shoufangdingdan);
        return this.queryById(shoufangdingdan.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shoufangdingdanDao.deleteById(id) > 0;
    }

    @Override
    public List<Shoufangdingdan> getpage(int pageNum, int pageSize, String query) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shoufangdingdan> shoufangdingdanList = shoufangdingdanDao.getpage(query);
        return shoufangdingdanList;

    }

    @Override
    public void updateIspayByid(Shoufangdingdan shoufangdingdan) {
        shoufangdingdanDao.updateIspayByid(shoufangdingdan);
    }

    @Override
    public void deleteByopidandid(String openid1, Long id) {
        this.shoufangdingdanDao.deleteByopidandid(openid1,id);
    }

    @Override
    public List<Shoufangdingdan> findall() {
        List<Shoufangdingdan> shoufangdingdanList = shoufangdingdanDao.findall();
        return shoufangdingdanList;
    }
}
