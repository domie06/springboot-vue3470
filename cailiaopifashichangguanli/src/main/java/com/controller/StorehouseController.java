package com.controller;





import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
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
 * 库房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/storehouse")
public class StorehouseController {
    private static final Logger logger = LoggerFactory.getLogger(StorehouseController.class);

    @Autowired
    private StorehouseService storehouseService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShanghuService shanghuService;

    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("商户".equals(role))
            params.put("shanghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = storehouseService.queryPage(params);

        //字典表数据转换
        List<StorehouseView> list =(List<StorehouseView>)page.getList();
        for(StorehouseView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        StorehouseEntity storehouse = storehouseService.selectById(id);
        if(storehouse !=null){
            //entity转view
            StorehouseView view = new StorehouseView();
            BeanUtils.copyProperties( storehouse , view );//把实体数据重构到view中

                //级联表
                ShanghuEntity shanghu = shanghuService.selectById(storehouse.getShanghuId());
                if(shanghu != null){
                    BeanUtils.copyProperties( shanghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShanghuId(shanghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody StorehouseEntity storehouse, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,storehouse:{}",this.getClass().getName(),storehouse.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("商户".equals(role))
            storehouse.setShanghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<StorehouseEntity> queryWrapper = new EntityWrapper<StorehouseEntity>()
            .eq("storehouse_name", storehouse.getStorehouseName())
            .eq("storehouse_address", storehouse.getStorehouseAddress())
            .eq("shanghu_id", storehouse.getShanghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        StorehouseEntity storehouseEntity = storehouseService.selectOne(queryWrapper);
        if(storehouseEntity==null){
            storehouse.setInsertTime(new Date());
            storehouseService.insert(storehouse);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody StorehouseEntity storehouse, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,storehouse:{}",this.getClass().getName(),storehouse.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("商户".equals(role))
            storehouse.setShanghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<StorehouseEntity> queryWrapper = new EntityWrapper<StorehouseEntity>()
            .notIn("id",storehouse.getId())
            .andNew()
            .eq("storehouse_name", storehouse.getStorehouseName())
            .eq("storehouse_address", storehouse.getStorehouseAddress())
            .eq("shanghu_id", storehouse.getShanghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        StorehouseEntity storehouseEntity = storehouseService.selectOne(queryWrapper);
        if(storehouseEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      storehouse.set
            //  }
            storehouseService.updateById(storehouse);//根据id更新
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
        storehouseService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

