package com.entity.vo;

import com.entity.FinanceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 市场财务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("finance")
public class FinanceVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
