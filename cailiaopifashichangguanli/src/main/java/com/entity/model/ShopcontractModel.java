package com.entity.model;

import com.entity.ShopcontractEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租赁合同
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShopcontractModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 合同名称
     */
    private String shopcontractName;


    /**
     * 合同
     */
    private String shopcontractFile;


    /**
     * 签订商户
     */
    private Integer shanghuId;


    /**
     * 签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shopcontractTime;


    /**
     * 备注
     */
    private String shopcontractContent;


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
	 * 获取：合同名称
	 */
    public String getShopcontractName() {
        return shopcontractName;
    }


    /**
	 * 设置：合同名称
	 */
    public void setShopcontractName(String shopcontractName) {
        this.shopcontractName = shopcontractName;
    }
    /**
	 * 获取：合同
	 */
    public String getShopcontractFile() {
        return shopcontractFile;
    }


    /**
	 * 设置：合同
	 */
    public void setShopcontractFile(String shopcontractFile) {
        this.shopcontractFile = shopcontractFile;
    }
    /**
	 * 获取：签订商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 设置：签订商户
	 */
    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
    }
    /**
	 * 获取：签订时间
	 */
    public Date getShopcontractTime() {
        return shopcontractTime;
    }


    /**
	 * 设置：签订时间
	 */
    public void setShopcontractTime(Date shopcontractTime) {
        this.shopcontractTime = shopcontractTime;
    }
    /**
	 * 获取：备注
	 */
    public String getShopcontractContent() {
        return shopcontractContent;
    }


    /**
	 * 设置：备注
	 */
    public void setShopcontractContent(String shopcontractContent) {
        this.shopcontractContent = shopcontractContent;
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
