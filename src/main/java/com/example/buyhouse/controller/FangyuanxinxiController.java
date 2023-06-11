package com.example.buyhouse.controller;


import com.example.buyhouse.entity.*;
import com.example.buyhouse.service.FangyuanxinxiService;
import com.example.buyhouse.service.ShoucangService;
import com.example.buyhouse.util.DateUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房源信息(Fangyuanxinxi)表控制层
 *
 * @author makejava
 * @since 2023-04-27 22:31:07
 */
@RestController
@RequestMapping("fangyuanxinxi")
public class FangyuanxinxiController {
    /**
     * 服务对象
     */
    @Resource
    private FangyuanxinxiService fangyuanxinxiService;
    @Resource
    private ShoucangService shoucangService;

    @Value("${fangyuantupian}")
    private String fangyuantupian;

    /**
     * 分页查询
     *
     * @param fangyuanxinxi 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Fangyuanxinxi>> queryByPage(Fangyuanxinxi fangyuanxinxi, PageRequest pageRequest) {
        return ResponseEntity.ok(this.fangyuanxinxiService.queryByPage(fangyuanxinxi, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Fangyuanxinxi> queryById(@PathVariable("id") Long id) {
        System.out.println(id);
//        Shoucang shoucangs = shoucangService.queryById(id);
//        if (shoucangs.equalsnull){
//            Shoucang shoucang = new Shoucang();
//            shoucang.setId(id);
//            shoucang.setValue("0");
//            shoucangService.insert(shoucang);
//        }else {
//            return ResponseEntity.ok(this.fangyuanxinxiService.queryById(id));
//        }


        return ResponseEntity.ok(this.fangyuanxinxiService.queryById(id));

    }

    /**
     * 新增数据
     *
     * @param fangyuanxinxi 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Fangyuanxinxi> add(Fangyuanxinxi fangyuanxinxi) {
        return ResponseEntity.ok(this.fangyuanxinxiService.insert(fangyuanxinxi));
    }

    /**
     * 编辑数据
     *
     * @param fangyuanxinxi 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Fangyuanxinxi> edit(Fangyuanxinxi fangyuanxinxi) {
        return ResponseEntity.ok(this.fangyuanxinxiService.update(fangyuanxinxi));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.fangyuanxinxiService.deleteById(id));
    }

    @RequestMapping("/fangyuanxinxi")
    public List<Fangyuanxinxi> fangyuanxinxis(){
        List<Fangyuanxinxi> fangyuanxinxis = fangyuanxinxiService.fangyuanxinxi();
        //System.out.println(fangyuanxinxis);
        return fangyuanxinxis;
    }

    @RequestMapping(value="/fyxxforvue")
    public Mapfenzhaung fyxxforvue(@RequestBody PageBean pageBean) throws IOException {
        System.out.println("*************************");
        System.out.println(pageBean.toString());
        String query=pageBean.getQuery().trim();


        List<Fangyuanxinxi> fangyuanxinxiList = fangyuanxinxiService.getpage(pageBean.getPageNum(), pageBean.getPageSize(),query);

        PageInfo<Fangyuanxinxi> pageInfo = new PageInfo<>(fangyuanxinxiList);

        System.out.println(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("fangyuanList",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println("*************************");
        return Mapfenzhaung.ok(map);
    }

    @GetMapping("/fysanchu/{id}")
    public Mapfenzhaung dindansanchu(@PathVariable(value = "id") Long id){
        System.out.println("````````````````````````");
        System.out.println(id);
        fangyuanxinxiService.deleteById(id);
        return Mapfenzhaung.ok();
    }


    @RequestMapping("/uploadImage")
    public Map<String,Object> uploadImage(MultipartFile file)throws Exception{
        Map<String,Object> resultMap=new HashMap<>();
        if(!file.isEmpty()){
            // 获取文件名
            String originalFilename = file.getOriginalFilename();
            String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName= DateUtil.getCurrentDateStr()+suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(fangyuantupian+newFileName));
            resultMap.put("code",0);
            resultMap.put("msg","上传成功");
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("title",newFileName);
            dataMap.put("src",newFileName);
            resultMap.put("data",dataMap);
        }
        return resultMap;
    }

    @RequestMapping("/save")
    public Mapfenzhaung save(@RequestBody Fangyuanxinxi fangyuanxinxi){
        System.out.println("这是房源信息换图片");
        System.out.println(fangyuanxinxi.toString());
        if(fangyuanxinxi.getId()==null || fangyuanxinxi.getId()==-1){
            fangyuanxinxiService.insert(fangyuanxinxi);
        }else{
            fangyuanxinxiService.updatetupian(fangyuanxinxi);
        }
        return Mapfenzhaung.ok();
    }

    @RequestMapping("/fangyuansave")
    public Mapfenzhaung fangyuansave(@RequestBody Fangyuanxinxi fangyuanxinxi){
        System.out.println("这是房源信息xiugai");
        System.out.println(fangyuanxinxi.toString());
        if(fangyuanxinxi.getId()==null || fangyuanxinxi.getId()==-1){
            fangyuanxinxiService.insert(fangyuanxinxi);
        }else{
            fangyuanxinxiService.update(fangyuanxinxi);
        }
        return Mapfenzhaung.ok();
    }

    @GetMapping("/findbyid/{id}")
    public Mapfenzhaung findById(@PathVariable(value = "id")Integer id){
        System.out.println("这是房源信息chaxun");
        System.out.println(id);
        Fangyuanxinxi fangyuanxinxi = fangyuanxinxiService.findbyid(id);
        Map<String,Object> map=new HashMap<>();
        map.put("product",fangyuanxinxi);
        return Mapfenzhaung.ok(map);
    }

    @RequestMapping("/shoushuomingcheng/{fname}")
    public List<Fangyuanxinxi> shoushuomingcheng(@PathVariable(value = "fname")String fname){
        System.out.println("这是房源信息搜索");
        System.out.println(fname);
        List<Fangyuanxinxi> fangyuanxinxishoushuoList = fangyuanxinxiService.findbyname(fname);
        System.out.println(fangyuanxinxishoushuoList);
        return fangyuanxinxishoushuoList;
    }

    @RequestMapping("/shaixuan")
    public List<Fangyuanxinxi> shaixuan(@RequestBody Map<String, ArrayList<String>> map){
        System.out.println("这是房源信息筛选");
        System.out.println(map);

        int size = map.get("s").size();
        String select = "'a' = 'a'";
        for (int i = 0;i<size;i++){
            String searchno = map.get("s").get(i);
            String[] searchtiaojian = searchno.toString().split(",");
            if(searchtiaojian[0].equals("1")){//价格
                if(searchtiaojian[2].equals("1")){
                    select = select + " and zongjine < 800000";
                }
                else if(searchtiaojian[2].equals("2")){
                    select = select + " and zongjine BETWEEN 800000 AND 1000000" ;
                }
                else if(searchtiaojian[2].equals("3")){
                    select = select + " and zongjine BETWEEN 1000000 AND 1500000";
                }
                else if(searchtiaojian[2].equals("4")){
                    select = select + " and zongjine BETWEEN 1500000 AND 2000000";
                }
                else if(searchtiaojian[2].equals("5")){
                    select = select + " and zongjine BETWEEN 2000000 AND 3000000";
                }
                else if(searchtiaojian[2].equals("6")){
                    select = select + " and zongjine BETWEEN 3000000 AND 4000000";
                }
                else if(searchtiaojian[2].equals("7")){
                    select = select + " and zongjine > 4000000";
                }

            }
            else if (searchtiaojian[0].equals("2")){//地区
                if(searchtiaojian[2].equals("1")){
                    select = select + " and fangyuanquyu like concat ('%','巴南区','%')";
                }
                else if(searchtiaojian[2].equals("2")){
                    select = select + " and fangyuanquyu like concat ('%','九龙坡','%')" ;
                }
                else if(searchtiaojian[2].equals("3")){
                    select = select + " and fangyuanquyu like concat ('%','南岸','%')";
                }
                else if(searchtiaojian[2].equals("4")){
                    select = select + " and fangyuanquyu like concat ('%','渝北','%')";
                }
                else if(searchtiaojian[2].equals("5")){
                    select = select + " and fangyuanquyu like concat ('%','江北','%')";
                }
                else if(searchtiaojian[2].equals("6")){
                    select = select + " and fangyuanquyu like concat ('%','沙坪坝','%')";
                }
                else if(searchtiaojian[2].equals("7")){
                    select = select + " and fangyuanquyu like concat ('%','永川','%')";
                }

            }
            else if (searchtiaojian[0].equals("3")){//户型
                if(searchtiaojian[2].equals("1")){
                    select = select + " and fangzihuxing like concat ('%','一','%')";
                }
                else if(searchtiaojian[2].equals("2")){
                    select = select + " and fangzihuxing like concat ('%','二','%')" ;
                }
                else if(searchtiaojian[2].equals("3")){
                    select = select + " and fangzihuxing like concat ('%','三','%')";
                }
                else if(searchtiaojian[2].equals("4")){
                    select = select + " and fangzihuxing like concat ('%','四','%')";
                }
                else if(searchtiaojian[2].equals("5")){
                    select = select + " and fangzihuxing  NOT IN (\"一房\",\"二房\",\"三房\",\"四房\")";
                }
            }
            else if (searchtiaojian[0].equals("4")){//筛选
                if(searchtiaojian[1].equals("1")){
                    if(searchtiaojian[2].equals("1")){
                        select = select + " and mianji < 80";
                    }
                    else if(searchtiaojian[2].equals("2")){
                        select = select + " and mianji BETWEEN 80 AND 90" ;
                    }
                    else if(searchtiaojian[2].equals("3")){
                        select = select + " and mianji BETWEEN 90 AND 100";
                    }
                    else if(searchtiaojian[2].equals("4")){
                        select = select + " and mianji BETWEEN 100 AND 120";
                    }
                    else if(searchtiaojian[2].equals("5")){
                        select = select + " and mianji BETWEEN 120 AND 150";
                    }
                    else if(searchtiaojian[2].equals("6")){
                        select = select + " and mianji BETWEEN 150 AND 200";
                    }
                    else if(searchtiaojian[2].equals("7")){
                        select = select + " and mianji BETWEEN 200 AND 300";
                    }
                    else if(searchtiaojian[2].equals("8")){
                        select = select + " and mianji > 300";
                    }

                }
                else if (searchtiaojian[1].equals("2")){
                    if(searchtiaojian[2].equals("1")){
                        select = select + " and zhuangtai like concat ('%','在售','%')";
                    }
                    else if(searchtiaojian[2].equals("2")){
                        select = select + " and zhuangtai like concat ('%','待售','%')" ;
                    }
                    else if(searchtiaojian[2].equals("3")){
                        select = select + " and zhuangtai like concat ('%','售罄','%')";
                    }

                }
                else if (searchtiaojian[1].equals("3")){
                    if(searchtiaojian[2].equals("1")){
                        select = select + " and zhuangxiu like concat ('%','毛坯','%')";
                    }
                    else if(searchtiaojian[2].equals("2")){
                        select = select + " and zhuangxiu like concat ('%','简装','%')" ;
                    }
                    else if(searchtiaojian[2].equals("3")){
                        select = select + " and zhuangxiu like concat ('%','精装','%')";
                    }
                }
                else if (searchtiaojian[1].equals("4")){
                    if(searchtiaojian[2].equals("1")){
                        select = select + " and fangyuanleixing like concat ('%','新房','%')";
                    }
                    else if(searchtiaojian[2].equals("2")){
                        select = select + " and fangyuanleixing like concat ('%','二手','%')" ;
                    }
                }

            }

            System.out.println(searchtiaojian[0]+searchtiaojian[1]+searchtiaojian[2]);

        }
        System.out.println(select);
        List<Fangyuanxinxi> selctfang = fangyuanxinxiService.sixuantiaojian(select);
        System.out.println(selctfang.toString());
        return selctfang;
    }

    @RequestMapping("/shoushuosershou")
    public List<Fangyuanxinxi> shoushuosershou(){
        System.out.println("这是房源二手房搜索");
        List<Fangyuanxinxi> shoushuosershouList = fangyuanxinxiService.shoushuosershou();
        System.out.println(shoushuosershouList);
        return shoushuosershouList;
    }
    @RequestMapping("/shoushuoxinfang")
    public List<Fangyuanxinxi> shoushuoxinfang(){
        System.out.println("这是房源新房搜索");
        List<Fangyuanxinxi> shoushuosershouList = fangyuanxinxiService.shoushuoxinfang();
        System.out.println(shoushuosershouList);
        return shoushuosershouList;
    }
    @RequestMapping("/shoushuoweikaipan")
    public List<Fangyuanxinxi> shoushuoweikaipan(){
        System.out.println("这是未开盘搜索");
        List<Fangyuanxinxi> shoushuoweikaipanList = fangyuanxinxiService.shoushuoweikaipan();
        System.out.println(shoushuoweikaipanList);
        return shoushuoweikaipanList;
    }
    @RequestMapping("/zhaoxiaoqu")
    public List<Fangyuanxinxi> zhaoxiaoqu(){
        System.out.println("这是找小区");
        List<Fangyuanxinxi> zhaoxiaoquList = fangyuanxinxiService.zhaoxiaoqu();
        System.out.println(zhaoxiaoquList);
        return zhaoxiaoquList;
    }

    @RequestMapping("/zhaohuxin")
    public List<Fangyuanxinxi> zhaohuxin(){
        System.out.println("这是找户型");
        List<Fangyuanxinxi> zhaohuxinList = fangyuanxinxiService.zhaohuxin();
        System.out.println(zhaohuxinList);
        return zhaohuxinList;
    }

    @RequestMapping("/chaozhaokeyword")
    public List<Fangyuanxinxi> shaixuankey(@RequestBody Fangyuanxinxi fangyuanxinxi) {
        System.out.println("这是根据关键词查");
        System.out.println(fangyuanxinxi.toString());
        List<Fangyuanxinxi> shaixuankeylist = fangyuanxinxiService.shaixuankey(fangyuanxinxi);
        return shaixuankeylist;
    }

    @RequestMapping("/chafangjia")
    public Mapfenzhaung chafangjia() {
        System.out.println("这是查房价");
        List<Fangyuanxinxi> shaixuankeylist = fangyuanxinxiService.chafangjia();
        Double zpinjun = 0.0;
        for(Fangyuanxinxi a:shaixuankeylist){
            zpinjun = zpinjun + Double.parseDouble(a.getZongjine());
        }
        Double pinjun = zpinjun/shaixuankeylist.size();
        Map<String,Object> map=new HashMap<>();
        map.put("f",shaixuankeylist);
        map.put("p",pinjun);
        return Mapfenzhaung.ok(map);
    }

    @RequestMapping("/jisuanfangdai")
    public Mapfenzhaung jisuanfangdai(@RequestBody Map<String,String> map) {
        System.out.println("这是计算房贷");
        System.out.println(map);
        BigDecimal dkje1 = new BigDecimal(map.get("dkje"));
        BigDecimal gjjl1 = new BigDecimal(map.get("gjjl"));
        BigDecimal yibai = new BigDecimal("100");
        gjjl1 = gjjl1.divide(yibai);
        BigDecimal gjjnx1 = new BigDecimal(map.get("gjjnx"));
        BigDecimal yue = new BigDecimal("12");
        BigDecimal yueliyu = gjjl1.divide(yue,2);
        BigDecimal yi = new BigDecimal("1");
        int zonqishu = Integer.parseInt(map.get("gjjnx"))*12;
        BigDecimal a = (dkje1.multiply(yueliyu).multiply(yueliyu.add(yi).pow(zonqishu)).divide((yueliyu.add(yi)).pow(zonqishu-1),2));
        a = a.setScale(2);
        Map<String,Object> aa = new HashMap<>();
        aa.put("meiyuehuan", a.toString());
        return Mapfenzhaung.ok(aa);
    }

    @GetMapping("/qitafangyuan/{id}")
    public List<Fangyuanxinxi> findexcpetid(@PathVariable("id") Long id) {
        System.out.println(id);
        List<Fangyuanxinxi> fangyuanxinxiList = fangyuanxinxiService.findexcpetid(id);
        return fangyuanxinxiList;

    }
}

