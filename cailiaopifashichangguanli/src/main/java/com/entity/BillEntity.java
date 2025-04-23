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
 * 商户账单
 *
 * @author 
 * @email
 */
@TableName("bill")
public class BillEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BillEntity() {

	}

	public BillEntity(T t) {
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

    @Override
    public String toString() {
        return "Bill{" +
            "id=" + id +
            ", billName=" + billName +
            ", billTypes=" + billTypes +
            ", shanghuId=" + shanghuId +
            ", billContent=" + billContent +
            ", billTime=" + billTime +
            ", insertTime=" + insertTime +
        "}";
    }
}
