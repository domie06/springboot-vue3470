package com.dao;

import com.entity.SecurityEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SecurityView;

/**
 * 安全管理 Dao 接口
 *
 * @author 
 */
public interface SecurityDao extends BaseMapper<SecurityEntity> {

   List<SecurityView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
