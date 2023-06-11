package com.example.buyhouse.service.impl;

import com.example.buyhouse.entity.Jingjiren;
import com.example.buyhouse.dao.JingjirenDao;
import com.example.buyhouse.service.JingjirenService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 经纪人(Jingjiren)表服务实现类
 *
 * @author makejava
 * @since 2023-05-11 18:42:02
 */
@Service("jingjirenService")
public class JingjirenServiceImpl implements JingjirenService {
    @Resource
    private JingjirenDao jingjirenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Jingjiren queryById(Long id) {
        return this.jingjirenDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param jingjiren 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Jingjiren> queryByPage(Jingjiren jingjiren, PageRequest pageRequest) {
        long total = this.jingjirenDao.count(jingjiren);
        return new PageImpl<>(this.jingjirenDao.queryAllByLimit(jingjiren, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param jingjiren 实例对象
     * @return 实例对象
     */
    @Override
    public Jingjiren insert(Jingjiren jingjiren) {
        this.jingjirenDao.insert(jingjiren);
        return jingjiren;
    }

    /**
     * 修改数据
     *
     * @param jingjiren 实例对象
     * @return 实例对象
     */
    @Override
    public Jingjiren update(Jingjiren jingjiren) {
        this.jingjirenDao.update(jingjiren);
        return this.queryById(jingjiren.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.jingjirenDao.deleteById(id) > 0;
    }

    @Override
    public List<Jingjiren> alljinjiren() {
        List<Jingjiren> alljinjiren = jingjirenDao.alljinjiren();
        return alljinjiren;
    }
}
