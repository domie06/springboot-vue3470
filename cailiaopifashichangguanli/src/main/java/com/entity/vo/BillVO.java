package com.entity.vo;

import com.entity.BillEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商户账单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bill")
public class BillVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账单标题
     */

    @TableField(value = "bill_name")
    private String billName;


    /**
     * 账单类型
     */

    @TableField(value = "bill_types")
    private Integer billTypes;


    /**
     * 商户
     */

    @TableField(value = "shanghu_id")
    private Integer shanghuId;


    /**
     * 备注
     */

    @TableField(value = "bill_content")
    private String billContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "bill_time")
    private Date billTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
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
	 * 设置：账单标题
	 */
    public String getBillName() {
        return billName;
    }


    /**
	 * 获取：账单标题
	 */

    public void setBillName(String billName) {
        this.billName = billName;
    }
    /**
	 * 设置：账单类型
	 */
    public Integer getBillTypes() {
        return billTypes;
    }


    /**
	 * 获取：账单类型
	 */

    public void setBillTypes(Integer billTypes) {
        this.billTypes = billTypes;
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
	 * 设置：备注
	 */
    public String getBillContent() {
        return billContent;
    }


    /**
	 * 获取：备注
	 */

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getBillTime() {
        return billTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
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

}
