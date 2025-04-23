package com.dao;

import com.entity.ShopleasingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShopleasingView;

/**
 * 商铺租赁 Dao 接口
 *
 * @author 
 */
public interface ShopleasingDao extends BaseMapper<ShopleasingEntity> {

   List<ShopleasingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
