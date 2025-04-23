package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShanghuEntity;
import java.util.Map;

/**
 * 商户 服务类
 */
public interface ShanghuService extends IService<ShanghuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}