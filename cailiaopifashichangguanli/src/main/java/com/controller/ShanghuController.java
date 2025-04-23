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
 * 商户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shanghu")
public class ShanghuController {
    private static final Logger logger = LoggerFactory.getLogger(ShanghuController.class);

    @Autowired
    private ShanghuService shanghuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        PageUtils page = shanghuService.queryPage(params);

        //字典表数据转换
        List<ShanghuView> list =(List<ShanghuView>)page.getList();
        for(ShanghuView c:list){
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
        ShanghuEntity shanghu = shanghuService.selectById(id);
        if(shanghu !=null){
            //entity转view
            ShanghuView view = new ShanghuView();
            BeanUtils.copyProperties( shanghu , view );//把实体数据重构到view中

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
    public R save(@RequestBody ShanghuEntity shanghu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shanghu:{}",this.getClass().getName(),shanghu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<ShanghuEntity> queryWrapper = new EntityWrapper<ShanghuEntity>()
            .eq("username", shanghu.getUsername())
            .or()
            .eq("shanghu_phone", shanghu.getShanghuPhone())
            .or()
            .eq("shanghu_id_number", shanghu.getShanghuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShanghuEntity shanghuEntity = shanghuService.selectOne(queryWrapper);
        if(shanghuEntity==null){
            shanghu.setCreateTime(new Date());
            shanghu.setPassword("123456");
            shanghuService.insert(shanghu);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShanghuEntity shanghu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shanghu:{}",this.getClass().getName(),shanghu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<ShanghuEntity> queryWrapper = new EntityWrapper<ShanghuEntity>()
            .notIn("id",shanghu.getId())
            .andNew()
            .eq("username", shanghu.getUsername())
            .or()
            .eq("shanghu_phone", shanghu.getShanghuPhone())
            .or()
            .eq("shanghu_id_number", shanghu.getShanghuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShanghuEntity shanghuEntity = shanghuService.selectOne(queryWrapper);
        if("".equals(shanghu.getShanghuPhoto()) || "null".equals(shanghu.getShanghuPhoto())){
                shanghu.setShanghuPhoto(null);
        }
        if(shanghuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shanghu.set
            //  }
            shanghuService.updateById(shanghu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shanghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ShanghuEntity shanghu = shanghuService.selectOne(new EntityWrapper<ShanghuEntity>().eq("username", username));
        if(shanghu==null || !shanghu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(shanghu.getId(),username, "shanghu", "商户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","商户");
        r.put("username",shanghu.getShanghuName());
        r.put("tableName","shanghu");
        r.put("userId",shanghu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ShanghuEntity shanghu){
    //    	ValidatorUtils.validateEntity(user);
        if(shanghuService.selectOne(new EntityWrapper<ShanghuEntity>().eq("username", shanghu.getUsername()).orNew().eq("shanghu_phone",shanghu.getShanghuPhone()).orNew().eq("shanghu_id_number",shanghu.getShanghuIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        shanghu.setCreateTime(new Date());
        shanghuService.insert(shanghu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ShanghuEntity shanghu = new ShanghuEntity();
        shanghu.setPassword("123456");
        shanghu.setId(id);
        shanghuService.updateById(shanghu);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrShanghu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ShanghuEntity shanghu = shanghuService.selectById(id);
        if(shanghu !=null){
            //entity转view
            ShanghuView view = new ShanghuView();
            BeanUtils.copyProperties( shanghu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

