package com.entity.model;

import com.entity.FinanceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 市场财务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FinanceModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String financeName;


    /**
     * 财务类型
     */
    private Integer financeTypes;


    /**
     * 涉及金额
     */
    private Double financeNumber;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date financeTime;


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
	 * 获取：标题
	 */
    public String getFinanceName() {
        return financeName;
    }


    /**
	 * 设置：标题
	 */
    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }
    /**
	 * 获取：财务类型
	 */
    public Integer getFinanceTypes() {
        return financeTypes;
    }


    /**
	 * 设置：财务类型
	 */
    public void setFinanceTypes(Integer financeTypes) {
        this.financeTypes = financeTypes;
    }
    /**
	 * 获取：涉及金额
	 */
    public Double getFinanceNumber() {
        return financeNumber;
    }


    /**
	 * 设置：涉及金额
	 */
    public void setFinanceNumber(Double financeNumber) {
        this.financeNumber = financeNumber;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getFinanceTime() {
        return financeTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setFinanceTime(Date financeTime) {
        this.financeTime = financeTime;
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
