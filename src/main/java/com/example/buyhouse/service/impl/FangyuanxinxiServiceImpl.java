package com.example.buyhouse.service.impl;

import com.example.buyhouse.dao.FangyuanxinxiDao;
import com.example.buyhouse.entity.Fangyuanxinxi;
import com.example.buyhouse.entity.Openid;
import com.example.buyhouse.service.FangyuanxinxiService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房源信息(Fangyuanxinxi)表服务实现类
 *
 * @author makejava
 * @since 2023-04-27 22:31:28
 */
@Service("fangyuanxinxiService")
public class FangyuanxinxiServiceImpl implements FangyuanxinxiService {
    @Resource
    private FangyuanxinxiDao fangyuanxinxiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Fangyuanxinxi queryById(Long id) {
        return this.fangyuanxinxiDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param fangyuanxinxi 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fangyuanxinxi> queryByPage(Fangyuanxinxi fangyuanxinxi, PageRequest pageRequest) {
        long total = this.fangyuanxinxiDao.count(fangyuanxinxi);
        return new PageImpl<>(this.fangyuanxinxiDao.queryAllByLimit(fangyuanxinxi, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fangyuanxinxi 实例对象
     * @return 实例对象
     */
    @Override
    public Fangyuanxinxi insert(Fangyuanxinxi fangyuanxinxi) {
        this.fangyuanxinxiDao.insert(fangyuanxinxi);
        return fangyuanxinxi;
    }

    /**
     * 修改数据
     *
     * @param fangyuanxinxi 实例对象
     * @return 实例对象
     */
    @Override
    public Fangyuanxinxi update(Fangyuanxinxi fangyuanxinxi) {
        this.fangyuanxinxiDao.update(fangyuanxinxi);
        return this.queryById(fangyuanxinxi.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.fangyuanxinxiDao.deleteById(id) > 0;
    }

    @Override
    public List<Fangyuanxinxi> fangyuanxinxi() {
        List<Fangyuanxinxi> fangyuanxinxis = fangyuanxinxiDao.fangyuanxinxi();
        return fangyuanxinxis;
    }

    @Override
    public List<Fangyuanxinxi> fangyuanxinxiBylsopid(String openid2) {
        List<Fangyuanxinxi> fangyuanxinxis= fangyuanxinxiDao. fangyuanxinxiBylsopid(openid2);
        return fangyuanxinxis;
    }

    @Override
    public List<Fangyuanxinxi> fangyuanxinxiByscopid(String openid2) {
        List<Fangyuanxinxi> fangyuanxinxis= fangyuanxinxiDao. fangyuanxinxiByscopid(openid2);
        return fangyuanxinxis;
    }

    @Override
    public List<Fangyuanxinxi> getpage(int pageNum, int pageSize, String query) {
        PageHelper.startPage(pageNum,pageSize);
        List<Fangyuanxinxi> fangyuanxinxiList = fangyuanxinxiDao.getpage(query);
        return fangyuanxinxiList;
    }

    @Override
    public void updatetupian(Fangyuanxinxi fangyuanxinxi) {
        this.fangyuanxinxiDao.updatetupian(fangyuanxinxi);
    }

    @Override
    public Fangyuanxinxi findbyid(Integer id) {
        Fangyuanxinxi f = fangyuanxinxiDao.findbyid(id);
        return f;
    }

    @Override
    public List<Fangyuanxinxi> findbyname(String fname) {
        List<Fangyuanxinxi> fangyuanxinxishoushuolist = fangyuanxinxiDao.findbyname(fname);
        return fangyuanxinxishoushuolist;
    }

    @Override
    public List<Fangyuanxinxi> sixuantiaojian(@Param("selec") String selec) {
        List<Fangyuanxinxi> saixuanf = fangyuanxinxiDao.sixuantiaojian(selec);
        return saixuanf;
    }

    @Override
    public List<Fangyuanxinxi> shoushuosershou() {
        List<Fangyuanxinxi> shoushuosershoulist = fangyuanxinxiDao.shoushuosershou();
        return shoushuosershoulist;
    }

    @Override
    public List<Fangyuanxinxi> shoushuoxinfang() {
        List<Fangyuanxinxi> shoushuoxinfanglist = fangyuanxinxiDao.shoushuoxinfang();
        return shoushuoxinfanglist;
    }

    @Override
    public List<Fangyuanxinxi> shoushuoweikaipan() {
        List<Fangyuanxinxi> shoushuoweikaipanlist = fangyuanxinxiDao.shoushuoweikaipan();
        return shoushuoweikaipanlist;
    }

    @Override
    public List<Fangyuanxinxi> zhaoxiaoqu() {
        List<Fangyuanxinxi> zhaoxiaoqulist = fangyuanxinxiDao.zhaoxiaoqu();
        return zhaoxiaoqulist;
    }

    @Override
    public List<Fangyuanxinxi> shaixuankey(Fangyuanxinxi fangyuanxinxi) {
        List<Fangyuanxinxi> shaixuankeylist = fangyuanxinxiDao.shaixuankey(fangyuanxinxi);
        return shaixuankeylist;
    }

    @Override
    public List<Fangyuanxinxi> zhaohuxin() {
        List<Fangyuanxinxi> zhaohuxinlist = fangyuanxinxiDao.zhaohuxin();
        return zhaohuxinlist;
    }

    @Override
    public List<Fangyuanxinxi> chafangjia() {
        List<Fangyuanxinxi> chafangjialist = fangyuanxinxiDao.chafangjia();
        return chafangjialist;
    }

    @Override
    public List<Fangyuanxinxi> findexcpetid(Long id) {
        List<Fangyuanxinxi> fangyuanxinxiList = fangyuanxinxiDao.findexcpetid(id);
        return fangyuanxinxiList;
    }
}
