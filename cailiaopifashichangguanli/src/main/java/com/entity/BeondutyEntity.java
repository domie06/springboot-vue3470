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
 * 卫生值班
 *
 * @author 
 * @email
 */
@TableName("beonduty")
public class BeondutyEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BeondutyEntity() {

	}

	public BeondutyEntity(T t) {
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
     * 值班日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "beOnDuty_time")

    private Date beondutyTime;


    /**
     * 值班人
     */
    @TableField(value = "beOnDuty_name")

    private String beondutyName;


    /**
     * 备注
     */
    @TableField(value = "beOnDuty_content")

    private String beondutyContent;


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
	 * 设置：值班日期
	 */
    public Date getBeondutyTime() {
        return beondutyTime;
    }


    /**
	 * 获取：值班日期
	 */

    public void setBeondutyTime(Date beondutyTime) {
        this.beondutyTime = beondutyTime;
    }
    /**
	 * 设置：值班人
	 */
    public String getBeondutyName() {
        return beondutyName;
    }


    /**
	 * 获取：值班人
	 */

    public void setBeondutyName(String beondutyName) {
        this.beondutyName = beondutyName;
    }
    /**
	 * 设置：备注
	 */
    public String getBeondutyContent() {
        return beondutyContent;
    }


    /**
	 * 获取：备注
	 */

    public void setBeondutyContent(String beondutyContent) {
        this.beondutyContent = beondutyContent;
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
        return "Beonduty{" +
            "id=" + id +
            ", beondutyTime=" + beondutyTime +
            ", beondutyName=" + beondutyName +
            ", beondutyContent=" + beondutyContent +
            ", insertTime=" + insertTime +
        "}";
    }
}
