package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShopcontractEntity;
import java.util.Map;

/**
 * 租赁合同 服务类
 */
public interface ShopcontractService extends IService<ShopcontractEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}