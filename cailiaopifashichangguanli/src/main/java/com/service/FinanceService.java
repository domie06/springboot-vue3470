package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FinanceEntity;
import java.util.Map;

/**
 * 市场财务 服务类
 */
public interface FinanceService extends IService<FinanceEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}