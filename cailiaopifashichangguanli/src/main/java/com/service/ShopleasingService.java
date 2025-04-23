package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShopleasingEntity;
import java.util.Map;

/**
 * 商铺租赁 服务类
 */
public interface ShopleasingService extends IService<ShopleasingEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}