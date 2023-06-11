package com.example.buyhouse.dao;

import com.example.buyhouse.entity.Fangyuanxinxi;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 房源信息(Fangyuanxinxi)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-27 22:32:48
 */
public interface FangyuanxinxiDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Fangyuanxinxi queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param fangyuanxinxi 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Fangyuanxinxi> queryAllByLimit(Fangyuanxinxi fangyuanxinxi, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param fangyuanxinxi 查询条件
     * @return 总行数
     */
    long count(Fangyuanxinxi fangyuanxinxi);

    /**
     * 新增数据
     *
     * @param fangyuanxinxi 实例对象
     * @return 影响行数
     */
    int insert(Fangyuanxinxi fangyuanxinxi);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fangyuanxinxi> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fangyuanxinxi> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Fangyuanxinxi> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Fangyuanxinxi> entities);

    /**
     * 修改数据
     *
     * @param fangyuanxinxi 实例对象
     * @return 影响行数
     */
    int update(Fangyuanxinxi fangyuanxinxi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Fangyuanxinxi> fangyuanxinxi();

    List<Fangyuanxinxi> fangyuanxinxiBylsopid(String openid2);

    List<Fangyuanxinxi> fangyuanxinxiByscopid(String openid2);

    List<Fangyuanxinxi> getpage(String query);

    void updatetupian(Fangyuanxinxi fangyuanxinxi);

    Fangyuanxinxi findbyid(Integer id);

    List<Fangyuanxinxi> findbyname(String fname);

    List<Fangyuanxinxi> sixuantiaojian(String selec);

    List<Fangyuanxinxi> shoushuosershou();

    List<Fangyuanxinxi> shoushuoxinfang();

    List<Fangyuanxinxi> shoushuoweikaipan();

    List<Fangyuanxinxi> zhaoxiaoqu();

    List<Fangyuanxinxi> shaixuankey(Fangyuanxinxi fangyuanxinxi);

    List<Fangyuanxinxi> zhaohuxin();

    List<Fangyuanxinxi> chafangjia();

    List<Fangyuanxinxi> findexcpetid(Long id);
}

