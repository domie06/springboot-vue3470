package com.entity.model;

import com.entity.HygieneEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 卫生管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HygieneModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 记录人
     */
    private String hygieneName;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date hygieneTime;


    /**
     * 打扫地址
     */
    private String hygieneContent;


    /**
     * 备注信息
     */
    private String beizhuContent;


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
	 * 获取：记录人
	 */
    public String getHygieneName() {
        return hygieneName;
    }


    /**
	 * 设置：记录人
	 */
    public void setHygieneName(String hygieneName) {
        this.hygieneName = hygieneName;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getHygieneTime() {
        return hygieneTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setHygieneTime(Date hygieneTime) {
        this.hygieneTime = hygieneTime;
    }
    /**
	 * 获取：打扫地址
	 */
    public String getHygieneContent() {
        return hygieneContent;
    }


    /**
	 * 设置：打扫地址
	 */
    public void setHygieneContent(String hygieneContent) {
        this.hygieneContent = hygieneContent;
    }
    /**
	 * 获取：备注信息
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 设置：备注信息
	 */
    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
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
