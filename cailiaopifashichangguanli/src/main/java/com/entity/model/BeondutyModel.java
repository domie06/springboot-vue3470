package com.entity.model;

import com.entity.BeondutyEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 卫生值班
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BeondutyModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 值班日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date beondutyTime;


    /**
     * 值班人
     */
    private String beondutyName;


    /**
     * 备注
     */
    private String beondutyContent;


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
	 * 获取：值班日期
	 */
    public Date getBeondutyTime() {
        return beondutyTime;
    }


    /**
	 * 设置：值班日期
	 */
    public void setBeondutyTime(Date beondutyTime) {
        this.beondutyTime = beondutyTime;
    }
    /**
	 * 获取：值班人
	 */
    public String getBeondutyName() {
        return beondutyName;
    }


    /**
	 * 设置：值班人
	 */
    public void setBeondutyName(String beondutyName) {
        this.beondutyName = beondutyName;
    }
    /**
	 * 获取：备注
	 */
    public String getBeondutyContent() {
        return beondutyContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBeondutyContent(String beondutyContent) {
        this.beondutyContent = beondutyContent;
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
