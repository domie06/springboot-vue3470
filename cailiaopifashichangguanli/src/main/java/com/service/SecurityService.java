package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SecurityEntity;
import java.util.Map;

/**
 * 安全管理 服务类
 */
public interface SecurityService extends IService<SecurityEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}