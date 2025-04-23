package com.entity.model;

import com.entity.StuffEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 材料
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class StuffModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 材料名称
     */
    private String stuffName;


    /**
     * 材料分类
     */
    private Integer stuffTypes;


    /**
     * 库存数量
     */
    private Integer stuffKucunNumber;


    /**
     * 所属库房
     */
    private Integer storehouseId;


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
	 * 获取：材料名称
	 */
    public String getStuffName() {
        return stuffName;
    }


    /**
	 * 设置：材料名称
	 */
    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }
    /**
	 * 获取：材料分类
	 */
    public Integer getStuffTypes() {
        return stuffTypes;
    }


    /**
	 * 设置：材料分类
	 */
    public void setStuffTypes(Integer stuffTypes) {
        this.stuffTypes = stuffTypes;
    }
    /**
	 * 获取：库存数量
	 */
    public Integer getStuffKucunNumber() {
        return stuffKucunNumber;
    }


    /**
	 * 设置：库存数量
	 */
    public void setStuffKucunNumber(Integer stuffKucunNumber) {
        this.stuffKucunNumber = stuffKucunNumber;
    }
    /**
	 * 获取：所属库房
	 */
    public Integer getStorehouseId() {
        return storehouseId;
    }


    /**
	 * 设置：所属库房
	 */
    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
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
