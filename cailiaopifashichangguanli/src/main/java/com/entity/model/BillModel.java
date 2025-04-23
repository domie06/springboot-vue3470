package com.entity.model;

import com.entity.BillEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商户账单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BillModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账单标题
     */
    private String billName;


    /**
     * 账单类型
     */
    private Integer billTypes;


    /**
     * 商户
     */
    private Integer shanghuId;


    /**
     * 备注
     */
    private String billContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date billTime;


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
	 * 获取：账单标题
	 */
    public String getBillName() {
        return billName;
    }


    /**
	 * 设置：账单标题
	 */
    public void setBillName(String billName) {
        this.billName = billName;
    }
    /**
	 * 获取：账单类型
	 */
    public Integer getBillTypes() {
        return billTypes;
    }


    /**
	 * 设置：账单类型
	 */
    public void setBillTypes(Integer billTypes) {
        this.billTypes = billTypes;
    }
    /**
	 * 获取：商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 设置：商户
	 */
    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
    }
    /**
	 * 获取：备注
	 */
    public String getBillContent() {
        return billContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getBillTime() {
        return billTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setBillTime(Date billTime) {
        this.billTime = billTime;
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
