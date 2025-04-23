package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.StorehouseEntity;
import java.util.Map;

/**
 * 库房 服务类
 */
public interface StorehouseService extends IService<StorehouseEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}