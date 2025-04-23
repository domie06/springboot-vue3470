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
 * 材料
 *
 * @author 
 * @email
 */
@TableName("stuff")
public class StuffEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public StuffEntity() {

	}

	public StuffEntity(T t) {
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
     * 材料名称
     */
    @TableField(value = "stuff_name")

    private String stuffName;


    /**
     * 材料分类
     */
    @TableField(value = "stuff_types")

    private Integer stuffTypes;


    /**
     * 库存数量
     */
    @TableField(value = "stuff_kucun_number")

    private Integer stuffKucunNumber;


    /**
     * 所属库房
     */
    @TableField(value = "storehouse_id")

    private Integer storehouseId;


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
	 * 设置：材料名称
	 */
    public String getStuffName() {
        return stuffName;
    }


    /**
	 * 获取：材料名称
	 */

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }
    /**
	 * 设置：材料分类
	 */
    public Integer getStuffTypes() {
        return stuffTypes;
    }


    /**
	 * 获取：材料分类
	 */

    public void setStuffTypes(Integer stuffTypes) {
        this.stuffTypes = stuffTypes;
    }
    /**
	 * 设置：库存数量
	 */
    public Integer getStuffKucunNumber() {
        return stuffKucunNumber;
    }


    /**
	 * 获取：库存数量
	 */

    public void setStuffKucunNumber(Integer stuffKucunNumber) {
        this.stuffKucunNumber = stuffKucunNumber;
    }
    /**
	 * 设置：所属库房
	 */
    public Integer getStorehouseId() {
        return storehouseId;
    }


    /**
	 * 获取：所属库房
	 */

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
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
        return "Stuff{" +
            "id=" + id +
            ", stuffName=" + stuffName +
            ", stuffTypes=" + stuffTypes +
            ", stuffKucunNumber=" + stuffKucunNumber +
            ", storehouseId=" + storehouseId +
            ", insertTime=" + insertTime +
        "}";
    }
}
