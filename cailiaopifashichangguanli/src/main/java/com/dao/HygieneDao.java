package com.dao;

import com.entity.HygieneEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HygieneView;

/**
 * 卫生管理 Dao 接口
 *
 * @author 
 */
public interface HygieneDao extends BaseMapper<HygieneEntity> {

   List<HygieneView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
