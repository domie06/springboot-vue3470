package com.dao;

import com.entity.StorehouseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.StorehouseView;

/**
 * 库房 Dao 接口
 *
 * @author 
 */
public interface StorehouseDao extends BaseMapper<StorehouseEntity> {

   List<StorehouseView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
