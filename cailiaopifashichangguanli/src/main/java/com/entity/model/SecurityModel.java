package com.entity.model;

import com.entity.SecurityEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 安全管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SecurityModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String securityName;


    /**
     * 类型
     */
    private Integer securityTypes;


    /**
     * 详情
     */
    private String securityContent;


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
    public String getSecurityName() {
        return securityName;
    }


    /**
	 * 设置：标题
	 */
    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }
    /**
	 * 获取：类型
	 */
    public Integer getSecurityTypes() {
        return securityTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setSecurityTypes(Integer securityTypes) {
        this.securityTypes = securityTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getSecurityContent() {
        return securityContent;
    }


    /**
	 * 设置：详情
	 */
    public void setSecurityContent(String securityContent) {
        this.securityContent = securityContent;
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
