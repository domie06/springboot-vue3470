package com.dao;

import com.entity.BillEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BillView;

/**
 * 商户账单 Dao 接口
 *
 * @author 
 */
public interface BillDao extends BaseMapper<BillEntity> {

   List<BillView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
