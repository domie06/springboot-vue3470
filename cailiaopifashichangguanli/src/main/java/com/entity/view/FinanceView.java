package com.entity.view;

import com.entity.FinanceEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 市场财务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("finance")
public class FinanceView extends FinanceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 财务类型的值
		*/
		private String financeValue;



	public FinanceView() {

	}

	public FinanceView(FinanceEntity financeEntity) {
		try {
			BeanUtils.copyProperties(this, financeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 财务类型的值
			*/
			public String getFinanceValue() {
				return financeValue;
			}
			/**
			* 设置： 财务类型的值
			*/
			public void setFinanceValue(String financeValue) {
				this.financeValue = financeValue;
			}















}
