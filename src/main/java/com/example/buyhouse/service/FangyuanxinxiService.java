package com.example.buyhouse.service;

import com.example.buyhouse.entity.Fangyuanxinxi;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 房源信息(Fangyuanxinxi)表服务接口
 *
 * @author makejava
 * @since 2023-04-27 22:31:28
 */
public interface FangyuanxinxiService {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fangyuanxinxi queryById(Long id);

    /**
     * 分页查询
     *
     * @param fangyuanxinxi 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Fangyuanxinxi> queryByPage(Fangyuanxinxi fangyuanxinxi, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param fangyuanxinxi 实例对象
     * @return 实例对象
     */
    Fangyuanxinxi insert(Fangyuanxinxi fangyuanxinxi);

    /**
     * 修改数据
     *
     * @param fangyuanxinxi 实例对象
     * @return 实例对象
     */
    Fangyuanxinxi update(Fangyuanxinxi fangyuanxinxi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Fangyuanxinxi> fangyuanxinxi();

    List<Fangyuanxinxi> fangyuanxinxiBylsopid(String openid2);

    List<Fangyuanxinxi> fangyuanxinxiByscopid(String openid2);

    List<Fangyuanxinxi> getpage(int pageNum, int pageSize, String query);

    void updatetupian(Fangyuanxinxi fangyuanxinxi);

    Fangyuanxinxi findbyid(Integer id);

    List<Fangyuanxinxi> findbyname(String fname);

    List<Fangyuanxinxi> sixuantiaojian(@Param("selec") String selec);

    List<Fangyuanxinxi> shoushuosershou();

    List<Fangyuanxinxi> shoushuoxinfang();

    List<Fangyuanxinxi> shoushuoweikaipan();

    List<Fangyuanxinxi> zhaoxiaoqu();

    List<Fangyuanxinxi> shaixuankey(Fangyuanxinxi fangyuanxinxi);

    List<Fangyuanxinxi> zhaohuxin();

    List<Fangyuanxinxi> chafangjia();

    List<Fangyuanxinxi> findexcpetid(Long id);
}
