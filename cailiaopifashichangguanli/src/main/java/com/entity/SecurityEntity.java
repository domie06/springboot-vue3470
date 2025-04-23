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
 * 安全管理
 *
 * @author 
 * @email
 */
@TableName("security")
public class SecurityEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SecurityEntity() {

	}

	public SecurityEntity(T t) {
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

    @Override
    public String toString() {
        return "Security{" +
            "id=" + id +
            ", securityName=" + securityName +
            ", securityTypes=" + securityTypes +
            ", securityContent=" + securityContent +
            ", financeTime=" + financeTime +
            ", insertTime=" + insertTime +
        "}";
    }
}
