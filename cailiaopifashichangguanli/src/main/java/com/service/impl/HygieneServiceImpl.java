package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.HygieneDao;
import com.entity.HygieneEntity;
import com.service.HygieneService;
import com.entity.view.HygieneView;

/**
 * 卫生管理 服务实现类
 */
@Service("hygieneService")
@Transactional
public class HygieneServiceImpl extends ServiceImpl<HygieneDao, HygieneEntity> implements HygieneService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HygieneView> page =new Query<HygieneView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
