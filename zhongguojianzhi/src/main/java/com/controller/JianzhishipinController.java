
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 剪纸教学视频
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianzhishipin")
public class JianzhishipinController {
    private static final Logger logger = LoggerFactory.getLogger(JianzhishipinController.class);

    @Autowired
    private JianzhishipinService jianzhishipinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("jianzhishipinDeleteStart",1);params.put("jianzhishipinDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jianzhishipinService.queryPage(params);

        //字典表数据转换
        List<JianzhishipinView> list =(List<JianzhishipinView>)page.getList();
        for(JianzhishipinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianzhishipinEntity jianzhishipin = jianzhishipinService.selectById(id);
        if(jianzhishipin !=null){
            //entity转view
            JianzhishipinView view = new JianzhishipinView();
            BeanUtils.copyProperties( jianzhishipin , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JianzhishipinEntity jianzhishipin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianzhishipin:{}",this.getClass().getName(),jianzhishipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JianzhishipinEntity> queryWrapper = new EntityWrapper<JianzhishipinEntity>()
            .eq("jianzhishipin_name", jianzhishipin.getJianzhishipinName())
            .eq("jianzhishipin_video", jianzhishipin.getJianzhishipinVideo())
            .eq("jianzhishipin_types", jianzhishipin.getJianzhishipinTypes())
            .eq("jianzhishipin_clicknum", jianzhishipin.getJianzhishipinClicknum())
            .eq("jianzhishipin_delete", jianzhishipin.getJianzhishipinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianzhishipinEntity jianzhishipinEntity = jianzhishipinService.selectOne(queryWrapper);
        if(jianzhishipinEntity==null){
            jianzhishipin.setJianzhishipinClicknum(1);
            jianzhishipin.setJianzhishipinDelete(1);
            jianzhishipin.setCreateTime(new Date());
            jianzhishipinService.insert(jianzhishipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianzhishipinEntity jianzhishipin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jianzhishipin:{}",this.getClass().getName(),jianzhishipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JianzhishipinEntity> queryWrapper = new EntityWrapper<JianzhishipinEntity>()
            .notIn("id",jianzhishipin.getId())
            .andNew()
            .eq("jianzhishipin_name", jianzhishipin.getJianzhishipinName())
            .eq("jianzhishipin_video", jianzhishipin.getJianzhishipinVideo())
            .eq("jianzhishipin_types", jianzhishipin.getJianzhishipinTypes())
            .eq("jianzhishipin_clicknum", jianzhishipin.getJianzhishipinClicknum())
            .eq("jianzhishipin_delete", jianzhishipin.getJianzhishipinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianzhishipinEntity jianzhishipinEntity = jianzhishipinService.selectOne(queryWrapper);
        if("".equals(jianzhishipin.getJianzhishipinPhoto()) || "null".equals(jianzhishipin.getJianzhishipinPhoto())){
                jianzhishipin.setJianzhishipinPhoto(null);
        }
        if("".equals(jianzhishipin.getJianzhishipinVideo()) || "null".equals(jianzhishipin.getJianzhishipinVideo())){
                jianzhishipin.setJianzhishipinVideo(null);
        }
        if(jianzhishipinEntity==null){
            jianzhishipinService.updateById(jianzhishipin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<JianzhishipinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JianzhishipinEntity jianzhishipinEntity = new JianzhishipinEntity();
            jianzhishipinEntity.setId(id);
            jianzhishipinEntity.setJianzhishipinDelete(2);
            list.add(jianzhishipinEntity);
        }
        if(list != null && list.size() >0){
            jianzhishipinService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JianzhishipinEntity> jianzhishipinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JianzhishipinEntity jianzhishipinEntity = new JianzhishipinEntity();
//                            jianzhishipinEntity.setJianzhishipinName(data.get(0));                    //视频名称 要改的
//                            jianzhishipinEntity.setJianzhishipinPhoto("");//详情和图片
//                            jianzhishipinEntity.setJianzhishipinVideo(data.get(0));                    //视频 要改的
//                            jianzhishipinEntity.setJianzhishipinTypes(Integer.valueOf(data.get(0)));   //视频类型 要改的
//                            jianzhishipinEntity.setJianzhishipinClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            jianzhishipinEntity.setJianzhishipinDelete(1);//逻辑删除字段
//                            jianzhishipinEntity.setJianzhishipinContent("");//详情和图片
//                            jianzhishipinEntity.setCreateTime(date);//时间
                            jianzhishipinList.add(jianzhishipinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jianzhishipinService.insertBatch(jianzhishipinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = jianzhishipinService.queryPage(params);

        //字典表数据转换
        List<JianzhishipinView> list =(List<JianzhishipinView>)page.getList();
        for(JianzhishipinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianzhishipinEntity jianzhishipin = jianzhishipinService.selectById(id);
            if(jianzhishipin !=null){

                //点击数量加1
                jianzhishipin.setJianzhishipinClicknum(jianzhishipin.getJianzhishipinClicknum()+1);
                jianzhishipinService.updateById(jianzhishipin);

                //entity转view
                JianzhishipinView view = new JianzhishipinView();
                BeanUtils.copyProperties( jianzhishipin , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JianzhishipinEntity jianzhishipin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jianzhishipin:{}",this.getClass().getName(),jianzhishipin.toString());
        Wrapper<JianzhishipinEntity> queryWrapper = new EntityWrapper<JianzhishipinEntity>()
            .eq("jianzhishipin_name", jianzhishipin.getJianzhishipinName())
            .eq("jianzhishipin_video", jianzhishipin.getJianzhishipinVideo())
            .eq("jianzhishipin_types", jianzhishipin.getJianzhishipinTypes())
            .eq("jianzhishipin_clicknum", jianzhishipin.getJianzhishipinClicknum())
            .eq("jianzhishipin_delete", jianzhishipin.getJianzhishipinDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianzhishipinEntity jianzhishipinEntity = jianzhishipinService.selectOne(queryWrapper);
        if(jianzhishipinEntity==null){
            jianzhishipin.setJianzhishipinDelete(1);
            jianzhishipin.setCreateTime(new Date());
        jianzhishipinService.insert(jianzhishipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
