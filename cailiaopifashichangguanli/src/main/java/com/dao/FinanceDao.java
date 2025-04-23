package com.dao;

import com.entity.FinanceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FinanceView;

/**
 * 市场财务 Dao 接口
 *
 * @author 
 */
public interface FinanceDao extends BaseMapper<FinanceEntity> {

   List<FinanceView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
