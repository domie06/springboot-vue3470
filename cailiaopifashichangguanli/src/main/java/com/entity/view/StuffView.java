package com.entity.view;

import com.entity.StuffEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 材料
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("stuff")
public class StuffView extends StuffEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 材料分类的值
		*/
		private String stuffValue;



		//级联表 storehouse
			/**
			* 库房分区
			*/
			private String storehouseName;
			/**
			* 库房地址
			*/
			private String storehouseAddress;
			/**
			* 商户
			*/
			private Integer shanghuId;

	public StuffView() {

	}

	public StuffView(StuffEntity stuffEntity) {
		try {
			BeanUtils.copyProperties(this, stuffEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 材料分类的值
			*/
			public String getStuffValue() {
				return stuffValue;
			}
			/**
			* 设置： 材料分类的值
			*/
			public void setStuffValue(String stuffValue) {
				this.stuffValue = stuffValue;
			}






















				//级联表的get和set storehouse
					/**
					* 获取： 库房分区
					*/
					public String getStorehouseName() {
						return storehouseName;
					}
					/**
					* 设置： 库房分区
					*/
					public void setStorehouseName(String storehouseName) {
						this.storehouseName = storehouseName;
					}
					/**
					* 获取： 库房地址
					*/
					public String getStorehouseAddress() {
						return storehouseAddress;
					}
					/**
					* 设置： 库房地址
					*/
					public void setStorehouseAddress(String storehouseAddress) {
						this.storehouseAddress = storehouseAddress;
					}
					/**
					* 获取： 商户
					*/
					public Integer getShanghuId() {
						return shanghuId;
					}
					/**
					* 设置： 商户
					*/
					public void setShanghuId(Integer shanghuId) {
						this.shanghuId = shanghuId;
					}






}
