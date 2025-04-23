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
 * 商铺租赁
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shopleasing")
public class ShopleasingController {
    private static final Logger logger = LoggerFactory.getLogger(ShopleasingController.class);

    @Autowired
    private ShopleasingService shopleasingService;


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
        PageUtils page = shopleasingService.queryPage(params);
        ArrayList<ShopleasingEntity> shopleasingEntities = new ArrayList<>();
        for (ShopleasingEntity leasing:(List<ShopleasingEntity>) page.getList()) {
            ShopleasingEntity shopleasingEntity = new ShopleasingEntity();
            Long leasingDate = leasing.getLeasingDate() * 2592000000L;
            Long leasingTime = leasing.getLeasingTime().getTime()+leasingDate;//到期时间
            Long newTime = new Date().getTime();//当前时间
            if((newTime > leasingTime) && leasing.getShangpuTypes() == 1){
                shopleasingEntity.setShangpuTypes(2);
                shopleasingEntity.setId(leasing.getId());
                shopleasingEntities.add(shopleasingEntity);
            }
        }
        if(shopleasingEntities.size() > 0){
            shopleasingService.updateBatchById(shopleasingEntities);
        }

        //字典表数据转换
        List<ShopleasingView> list =(List<ShopleasingView>)page.getList();
        for(ShopleasingView c:list){
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
        ShopleasingEntity shopleasing = shopleasingService.selectById(id);
        if(shopleasing !=null){
            //entity转view
            ShopleasingView view = new ShopleasingView();
            BeanUtils.copyProperties( shopleasing , view );//把实体数据重构到view中

                //级联表
                ShanghuEntity shanghu = shanghuService.selectById(shopleasing.getShanghuId());
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
    public R save(@RequestBody ShopleasingEntity shopleasing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shopleasing:{}",this.getClass().getName(),shopleasing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("商户".equals(role))
            shopleasing.setShanghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<ShopleasingEntity> queryWrapper = new EntityWrapper<ShopleasingEntity>()
            .eq("shopLeasing_name", shopleasing.getShopleasingName())
            .eq("shopLeasing_address", shopleasing.getShopleasingAddress())
            .eq("shangpu_types", shopleasing.getShangpuTypes())
            .eq("shop_types", shopleasing.getShopTypes())
            .eq("shanghu_id", shopleasing.getShanghuId())
            .eq("leasing_date", shopleasing.getLeasingDate())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShopleasingEntity shopleasingEntity = shopleasingService.selectOne(queryWrapper);
        if(shopleasingEntity==null){
            shopleasing.setInsertTime(new Date());
            shopleasingService.insert(shopleasing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShopleasingEntity shopleasing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shopleasing:{}",this.getClass().getName(),shopleasing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("商户".equals(role))
            shopleasing.setShanghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShopleasingEntity> queryWrapper = new EntityWrapper<ShopleasingEntity>()
            .notIn("id",shopleasing.getId())
            .andNew()
            .eq("shopLeasing_name", shopleasing.getShopleasingName())
            .eq("shopLeasing_address", shopleasing.getShopleasingAddress())
            .eq("shangpu_types", shopleasing.getShangpuTypes())
            .eq("shop_types", shopleasing.getShopTypes())
            .eq("shanghu_id", shopleasing.getShanghuId())
            .eq("leasing_date", shopleasing.getLeasingDate())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShopleasingEntity shopleasingEntity = shopleasingService.selectOne(queryWrapper);
        if(shopleasingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shopleasing.set
            //  }
            shopleasingService.updateById(shopleasing);//根据id更新
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
        shopleasingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

