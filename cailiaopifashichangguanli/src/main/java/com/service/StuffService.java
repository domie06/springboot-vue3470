package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.StuffEntity;
import java.util.Map;

/**
 * 材料 服务类
 */
public interface StuffService extends IService<StuffEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}