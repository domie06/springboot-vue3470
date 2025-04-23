package com.entity.vo;

import com.entity.SecurityEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 安全管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("security")
public class SecurityVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "security_name")
    private String securityName;


    /**
     * 类型
     */

    @TableField(value = "security_types")
    private Integer securityTypes;


    /**
     * 详情
     */

    @TableField(value = "security_content")
    private String securityContent;


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
    public String getSecurityName() {
        return securityName;
    }


    /**
	 * 获取：标题
	 */

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }
    /**
	 * 设置：类型
	 */
    public Integer getSecurityTypes() {
        return securityTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setSecurityTypes(Integer securityTypes) {
        this.securityTypes = securityTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getSecurityContent() {
        return securityContent;
    }


    /**
	 * 获取：详情
	 */

    public void setSecurityContent(String securityContent) {
        this.securityContent = securityContent;
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
