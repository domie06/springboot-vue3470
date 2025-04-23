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
 * 员工
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuangong")
public class YuangongController {
    private static final Logger logger = LoggerFactory.getLogger(YuangongController.class);

    @Autowired
    private YuangongService yuangongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private ShanghuService shanghuService;


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
        PageUtils page = yuangongService.queryPage(params);

        //字典表数据转换
        List<YuangongView> list =(List<YuangongView>)page.getList();
        for(YuangongView c:list){
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
        YuangongEntity yuangong = yuangongService.selectById(id);
        if(yuangong !=null){
            //entity转view
            YuangongView view = new YuangongView();
            BeanUtils.copyProperties( yuangong , view );//把实体数据重构到view中

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
    public R save(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuangong:{}",this.getClass().getName(),yuangong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<YuangongEntity> queryWrapper = new EntityWrapper<YuangongEntity>()
            .eq("username", yuangong.getUsername())
            .or()
            .eq("yuangong_phone", yuangong.getYuangongPhone())
            .or()
            .eq("yuangong_id_number", yuangong.getYuangongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongEntity yuangongEntity = yuangongService.selectOne(queryWrapper);
        if(yuangongEntity==null){
            yuangong.setCreateTime(new Date());
            yuangong.setPassword("123456");
            yuangongService.insert(yuangong);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongEntity yuangong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yuangong:{}",this.getClass().getName(),yuangong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<YuangongEntity> queryWrapper = new EntityWrapper<YuangongEntity>()
            .notIn("id",yuangong.getId())
            .andNew()
            .eq("username", yuangong.getUsername())
            .or()
            .eq("yuangong_phone", yuangong.getYuangongPhone())
            .or()
            .eq("yuangong_id_number", yuangong.getYuangongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuangongEntity yuangongEntity = yuangongService.selectOne(queryWrapper);
        if("".equals(yuangong.getYuangongPhoto()) || "null".equals(yuangong.getYuangongPhoto())){
                yuangong.setYuangongPhoto(null);
        }
        if(yuangongEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yuangong.set
            //  }
            yuangongService.updateById(yuangong);//根据id更新
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
        yuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YuangongEntity yuangong = yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("username", username));
        if(yuangong==null || !yuangong.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(yuangong.getId(),username, "yuangong", "员工");
        R r = R.ok();
        r.put("token", token);
        r.put("role","员工");
        r.put("username",yuangong.getYuangongName());
        r.put("tableName","yuangong");
        r.put("userId",yuangong.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YuangongEntity yuangong){
    //    	ValidatorUtils.validateEntity(user);
        if(yuangongService.selectOne(new EntityWrapper<YuangongEntity>().eq("username", yuangong.getUsername()).orNew().eq("yuangong_phone",yuangong.getYuangongPhone()).orNew().eq("yuangong_id_number",yuangong.getYuangongIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        yuangong.setCreateTime(new Date());
        yuangongService.insert(yuangong);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        YuangongEntity yuangong = new YuangongEntity();
        yuangong.setPassword("123456");
        yuangong.setId(id);
        yuangongService.updateById(yuangong);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYuangong(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YuangongEntity yuangong = yuangongService.selectById(id);
        if(yuangong !=null){
            //entity转view
            YuangongView view = new YuangongView();
            BeanUtils.copyProperties( yuangong , view );//把实体数据重构到view中

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

