package com.entity.vo;

import com.entity.BeondutyEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 卫生值班
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("beonduty")
public class BeondutyVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
