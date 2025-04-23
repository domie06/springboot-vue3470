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
 * 商铺租赁
 *
 * @author 
 * @email
 */
@TableName("shopleasing")
public class ShopleasingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShopleasingEntity() {

	}

	public ShopleasingEntity(T t) {
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
     * 商铺名称
     */
    @TableField(value = "shopLeasing_name")

    private String shopleasingName;


    /**
     * 商铺地址
     */
    @TableField(value = "shopLeasing_address")

    private String shopleasingAddress;


    /**
     * 商铺状态
     */
    @TableField(value = "shangpu_types")

    private Integer shangpuTypes;


    /**
     * 商铺类型
     */
    @TableField(value = "shop_types")

    private Integer shopTypes;


    /**
     * 租金（月）
     */
    @TableField(value = "shangpu_new_money")

    private Double shangpuNewMoney;


    /**
     * 租赁商户
     */
    @TableField(value = "shanghu_id")

    private Integer shanghuId;


    /**
     * 租赁日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "leasing_time")

    private Date leasingTime;


    /**
     * 租赁时间（月）
     */
    @TableField(value = "leasing_date")

    private Integer leasingDate;


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
	 * 设置：商铺名称
	 */
    public String getShopleasingName() {
        return shopleasingName;
    }


    /**
	 * 获取：商铺名称
	 */

    public void setShopleasingName(String shopleasingName) {
        this.shopleasingName = shopleasingName;
    }
    /**
	 * 设置：商铺地址
	 */
    public String getShopleasingAddress() {
        return shopleasingAddress;
    }


    /**
	 * 获取：商铺地址
	 */

    public void setShopleasingAddress(String shopleasingAddress) {
        this.shopleasingAddress = shopleasingAddress;
    }
    /**
	 * 设置：商铺状态
	 */
    public Integer getShangpuTypes() {
        return shangpuTypes;
    }


    /**
	 * 获取：商铺状态
	 */

    public void setShangpuTypes(Integer shangpuTypes) {
        this.shangpuTypes = shangpuTypes;
    }
    /**
	 * 设置：商铺类型
	 */
    public Integer getShopTypes() {
        return shopTypes;
    }


    /**
	 * 获取：商铺类型
	 */

    public void setShopTypes(Integer shopTypes) {
        this.shopTypes = shopTypes;
    }
    /**
	 * 设置：租金（月）
	 */
    public Double getShangpuNewMoney() {
        return shangpuNewMoney;
    }


    /**
	 * 获取：租金（月）
	 */

    public void setShangpuNewMoney(Double shangpuNewMoney) {
        this.shangpuNewMoney = shangpuNewMoney;
    }
    /**
	 * 设置：租赁商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 获取：租赁商户
	 */

    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
    }
    /**
	 * 设置：租赁日期
	 */
    public Date getLeasingTime() {
        return leasingTime;
    }


    /**
	 * 获取：租赁日期
	 */

    public void setLeasingTime(Date leasingTime) {
        this.leasingTime = leasingTime;
    }
    /**
	 * 设置：租赁时间（月）
	 */
    public Integer getLeasingDate() {
        return leasingDate;
    }


    /**
	 * 获取：租赁时间（月）
	 */

    public void setLeasingDate(Integer leasingDate) {
        this.leasingDate = leasingDate;
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
        return "Shopleasing{" +
            "id=" + id +
            ", shopleasingName=" + shopleasingName +
            ", shopleasingAddress=" + shopleasingAddress +
            ", shangpuTypes=" + shangpuTypes +
            ", shopTypes=" + shopTypes +
            ", shangpuNewMoney=" + shangpuNewMoney +
            ", shanghuId=" + shanghuId +
            ", leasingTime=" + leasingTime +
            ", leasingDate=" + leasingDate +
            ", insertTime=" + insertTime +
        "}";
    }
}
