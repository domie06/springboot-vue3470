package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HygieneEntity;
import java.util.Map;

/**
 * 卫生管理 服务类
 */
public interface HygieneService extends IService<HygieneEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}