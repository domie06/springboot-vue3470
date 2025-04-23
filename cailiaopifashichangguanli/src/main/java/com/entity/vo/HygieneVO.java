package com.entity.vo;

import com.entity.HygieneEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 卫生管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hygiene")
public class HygieneVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 记录人
     */

    @TableField(value = "hygiene_name")
    private String hygieneName;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "hygiene_time")
    private Date hygieneTime;


    /**
     * 打扫地址
     */

    @TableField(value = "hygiene_content")
    private String hygieneContent;


    /**
     * 备注信息
     */

    @TableField(value = "beizhu_content")
    private String beizhuContent;


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
	 * 设置：记录人
	 */
    public String getHygieneName() {
        return hygieneName;
    }


    /**
	 * 获取：记录人
	 */

    public void setHygieneName(String hygieneName) {
        this.hygieneName = hygieneName;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getHygieneTime() {
        return hygieneTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setHygieneTime(Date hygieneTime) {
        this.hygieneTime = hygieneTime;
    }
    /**
	 * 设置：打扫地址
	 */
    public String getHygieneContent() {
        return hygieneContent;
    }


    /**
	 * 获取：打扫地址
	 */

    public void setHygieneContent(String hygieneContent) {
        this.hygieneContent = hygieneContent;
    }
    /**
	 * 设置：备注信息
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 获取：备注信息
	 */

    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
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
