package com.entity.view;

import com.entity.ShopleasingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商铺租赁
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shopleasing")
public class ShopleasingView extends ShopleasingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 商铺状态的值
		*/
		private String shangpuValue;
		/**
		* 商铺类型的值
		*/
		private String shopValue;



		//级联表 shanghu
			/**
			* 商户姓名
			*/
			private String shanghuName;
			/**
			* 身份证号
			*/
			private String shanghuIdNumber;
			/**
			* 手机号
			*/
			private String shanghuPhone;
			/**
			* 邮箱
			*/
			private String shanghuEmail;
			/**
			* 照片
			*/
			private String shanghuPhoto;

	public ShopleasingView() {

	}

	public ShopleasingView(ShopleasingEntity shopleasingEntity) {
		try {
			BeanUtils.copyProperties(this, shopleasingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 商铺状态的值
			*/
			public String getShangpuValue() {
				return shangpuValue;
			}
			/**
			* 设置： 商铺状态的值
			*/
			public void setShangpuValue(String shangpuValue) {
				this.shangpuValue = shangpuValue;
			}
			/**
			* 获取： 商铺类型的值
			*/
			public String getShopValue() {
				return shopValue;
			}
			/**
			* 设置： 商铺类型的值
			*/
			public void setShopValue(String shopValue) {
				this.shopValue = shopValue;
			}
















				//级联表的get和set shanghu
					/**
					* 获取： 商户姓名
					*/
					public String getShanghuName() {
						return shanghuName;
					}
					/**
					* 设置： 商户姓名
					*/
					public void setShanghuName(String shanghuName) {
						this.shanghuName = shanghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getShanghuIdNumber() {
						return shanghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setShanghuIdNumber(String shanghuIdNumber) {
						this.shanghuIdNumber = shanghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getShanghuPhone() {
						return shanghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setShanghuPhone(String shanghuPhone) {
						this.shanghuPhone = shanghuPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getShanghuEmail() {
						return shanghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setShanghuEmail(String shanghuEmail) {
						this.shanghuEmail = shanghuEmail;
					}
					/**
					* 获取： 照片
					*/
					public String getShanghuPhoto() {
						return shanghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setShanghuPhoto(String shanghuPhoto) {
						this.shanghuPhoto = shanghuPhoto;
					}












}
