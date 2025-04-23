package com.entity.model;

import com.entity.StorehouseEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 库房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class StorehouseModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 库房分区
     */
    private String storehouseName;


    /**
     * 库房地址
     */
    private String storehouseAddress;


    /**
     * 商户
     */
    private Integer shanghuId;


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
	 * 获取：库房分区
	 */
    public String getStorehouseName() {
        return storehouseName;
    }


    /**
	 * 设置：库房分区
	 */
    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }
    /**
	 * 获取：库房地址
	 */
    public String getStorehouseAddress() {
        return storehouseAddress;
    }


    /**
	 * 设置：库房地址
	 */
    public void setStorehouseAddress(String storehouseAddress) {
        this.storehouseAddress = storehouseAddress;
    }
    /**
	 * 获取：商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 设置：商户
	 */
    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
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
