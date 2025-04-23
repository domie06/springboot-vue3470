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
 * 市场财务
 *
 * @author 
 * @email
 */
@TableName("finance")
public class FinanceEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FinanceEntity() {

	}

	public FinanceEntity(T t) {
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
     * 标题
     */
    @TableField(value = "finance_name")

    private String financeName;


    /**
     * 财务类型
     */
    @TableField(value = "finance_types")

    private Integer financeTypes;


    /**
     * 涉及金额
     */
    @TableField(value = "finance_number")

    private Double financeNumber;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "finance_time")

    private Date financeTime;


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
	 * 设置：标题
	 */
    public String getFinanceName() {
        return financeName;
    }


    /**
	 * 获取：标题
	 */

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }
    /**
	 * 设置：财务类型
	 */
    public Integer getFinanceTypes() {
        return financeTypes;
    }


    /**
	 * 获取：财务类型
	 */

    public void setFinanceTypes(Integer financeTypes) {
        this.financeTypes = financeTypes;
    }
    /**
	 * 设置：涉及金额
	 */
    public Double getFinanceNumber() {
        return financeNumber;
    }


    /**
	 * 获取：涉及金额
	 */

    public void setFinanceNumber(Double financeNumber) {
        this.financeNumber = financeNumber;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getFinanceTime() {
        return financeTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setFinanceTime(Date financeTime) {
        this.financeTime = financeTime;
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
        return "Finance{" +
            "id=" + id +
            ", financeName=" + financeName +
            ", financeTypes=" + financeTypes +
            ", financeNumber=" + financeNumber +
            ", financeTime=" + financeTime +
            ", insertTime=" + insertTime +
        "}";
    }
}
