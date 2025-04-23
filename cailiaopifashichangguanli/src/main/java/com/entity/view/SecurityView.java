package com.entity.view;

import com.entity.SecurityEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 安全管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("security")
public class SecurityView extends SecurityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String securityValue;



	public SecurityView() {

	}

	public SecurityView(SecurityEntity securityEntity) {
		try {
			BeanUtils.copyProperties(this, securityEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getSecurityValue() {
				return securityValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setSecurityValue(String securityValue) {
				this.securityValue = securityValue;
			}















}
