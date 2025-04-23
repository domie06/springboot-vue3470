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
 * 市场财务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/finance")
public class FinanceController {
    private static final Logger logger = LoggerFactory.getLogger(FinanceController.class);

    @Autowired
    private FinanceService financeService;


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
        PageUtils page = financeService.queryPage(params);

        //字典表数据转换
        List<FinanceView> list =(List<FinanceView>)page.getList();
        for(FinanceView c:list){
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
        FinanceEntity finance = financeService.selectById(id);
        if(finance !=null){
            //entity转view
            FinanceView view = new FinanceView();
            BeanUtils.copyProperties( finance , view );//把实体数据重构到view中

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
    public R save(@RequestBody FinanceEntity finance, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,finance:{}",this.getClass().getName(),finance.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<FinanceEntity> queryWrapper = new EntityWrapper<FinanceEntity>()
            .eq("finance_name", finance.getFinanceName())
            .eq("finance_types", finance.getFinanceTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FinanceEntity financeEntity = financeService.selectOne(queryWrapper);
        if(financeEntity==null){
            finance.setInsertTime(new Date());
            financeService.insert(finance);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FinanceEntity finance, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,finance:{}",this.getClass().getName(),finance.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<FinanceEntity> queryWrapper = new EntityWrapper<FinanceEntity>()
            .notIn("id",finance.getId())
            .andNew()
            .eq("finance_name", finance.getFinanceName())
            .eq("finance_types", finance.getFinanceTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FinanceEntity financeEntity = financeService.selectOne(queryWrapper);
        if(financeEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      finance.set
            //  }
            financeService.updateById(finance);//根据id更新
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
        financeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

