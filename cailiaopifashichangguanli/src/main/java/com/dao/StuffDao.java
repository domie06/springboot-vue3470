package com.dao;

import com.entity.StuffEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.StuffView;

/**
 * 材料 Dao 接口
 *
 * @author 
 */
public interface StuffDao extends BaseMapper<StuffEntity> {

   List<StuffView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
