package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 库房
 *
 * @author 
 * @email
 */
@TableName("storehouse")
public class StorehouseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public StorehouseEntity() {

	}

	public StorehouseEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 库房分区
     */
    @TableField(value = "storehouse_name")

    private String storehouseName;


    /**
     * 库房地址
     */
    @TableField(value = "storehouse_address")

    private String storehouseAddress;


    /**
     * 商户
     */
    @TableField(value = "shanghu_id")

    private Integer shanghuId;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：库房分区
	 */
    public String getStorehouseName() {
        return storehouseName;
    }


    /**
	 * 获取：库房分区
	 */

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }
    /**
	 * 设置：库房地址
	 */
    public String getStorehouseAddress() {
        return storehouseAddress;
    }


    /**
	 * 获取：库房地址
	 */

    public void setStorehouseAddress(String storehouseAddress) {
        this.storehouseAddress = storehouseAddress;
    }
    /**
	 * 设置：商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 获取：商户
	 */

    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Storehouse{" +
            "id=" + id +
            ", storehouseName=" + storehouseName +
            ", storehouseAddress=" + storehouseAddress +
            ", shanghuId=" + shanghuId +
            ", insertTime=" + insertTime +
        "}";
    }
}
