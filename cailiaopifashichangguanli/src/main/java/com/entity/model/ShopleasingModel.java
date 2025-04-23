package com.entity.model;

import com.entity.ShopleasingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商铺租赁
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShopleasingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商铺名称
     */
    private String shopleasingName;


    /**
     * 商铺地址
     */
    private String shopleasingAddress;


    /**
     * 商铺状态
     */
    private Integer shangpuTypes;


    /**
     * 商铺类型
     */
    private Integer shopTypes;


    /**
     * 租金（月）
     */
    private Double shangpuNewMoney;


    /**
     * 租赁商户
     */
    private Integer shanghuId;


    /**
     * 租赁日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date leasingTime;


    /**
     * 租赁时间（月）
     */
    private Integer leasingDate;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商铺名称
	 */
    public String getShopleasingName() {
        return shopleasingName;
    }


    /**
	 * 设置：商铺名称
	 */
    public void setShopleasingName(String shopleasingName) {
        this.shopleasingName = shopleasingName;
    }
    /**
	 * 获取：商铺地址
	 */
    public String getShopleasingAddress() {
        return shopleasingAddress;
    }


    /**
	 * 设置：商铺地址
	 */
    public void setShopleasingAddress(String shopleasingAddress) {
        this.shopleasingAddress = shopleasingAddress;
    }
    /**
	 * 获取：商铺状态
	 */
    public Integer getShangpuTypes() {
        return shangpuTypes;
    }


    /**
	 * 设置：商铺状态
	 */
    public void setShangpuTypes(Integer shangpuTypes) {
        this.shangpuTypes = shangpuTypes;
    }
    /**
	 * 获取：商铺类型
	 */
    public Integer getShopTypes() {
        return shopTypes;
    }


    /**
	 * 设置：商铺类型
	 */
    public void setShopTypes(Integer shopTypes) {
        this.shopTypes = shopTypes;
    }
    /**
	 * 获取：租金（月）
	 */
    public Double getShangpuNewMoney() {
        return shangpuNewMoney;
    }


    /**
	 * 设置：租金（月）
	 */
    public void setShangpuNewMoney(Double shangpuNewMoney) {
        this.shangpuNewMoney = shangpuNewMoney;
    }
    /**
	 * 获取：租赁商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 设置：租赁商户
	 */
    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
    }
    /**
	 * 获取：租赁日期
	 */
    public Date getLeasingTime() {
        return leasingTime;
    }


    /**
	 * 设置：租赁日期
	 */
    public void setLeasingTime(Date leasingTime) {
        this.leasingTime = leasingTime;
    }
    /**
	 * 获取：租赁时间（月）
	 */
    public Integer getLeasingDate() {
        return leasingDate;
    }


    /**
	 * 设置：租赁时间（月）
	 */
    public void setLeasingDate(Integer leasingDate) {
        this.leasingDate = leasingDate;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    }
