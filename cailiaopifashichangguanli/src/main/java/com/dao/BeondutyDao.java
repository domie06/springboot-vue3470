package com.dao;

import com.entity.BeondutyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BeondutyView;

/**
 * 卫生值班 Dao 接口
 *
 * @author 
 */
public interface BeondutyDao extends BaseMapper<BeondutyEntity> {

   List<BeondutyView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
