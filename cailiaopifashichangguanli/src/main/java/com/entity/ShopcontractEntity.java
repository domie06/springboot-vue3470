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
 * 租赁合同
 *
 * @author 
 * @email
 */
@TableName("shopcontract")
public class ShopcontractEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShopcontractEntity() {

	}

	public ShopcontractEntity(T t) {
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
     * 合同名称
     */
    @TableField(value = "shopContract_name")

    private String shopcontractName;


    /**
     * 合同
     */
    @TableField(value = "shopContract_file")

    private String shopcontractFile;


    /**
     * 签订商户
     */
    @TableField(value = "shanghu_id")

    private Integer shanghuId;


    /**
     * 签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shopContract_time")

    private Date shopcontractTime;


    /**
     * 备注
     */
    @TableField(value = "shopContract_content")

    private String shopcontractContent;


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
	 * 设置：合同名称
	 */
    public String getShopcontractName() {
        return shopcontractName;
    }


    /**
	 * 获取：合同名称
	 */

    public void setShopcontractName(String shopcontractName) {
        this.shopcontractName = shopcontractName;
    }
    /**
	 * 设置：合同
	 */
    public String getShopcontractFile() {
        return shopcontractFile;
    }


    /**
	 * 获取：合同
	 */

    public void setShopcontractFile(String shopcontractFile) {
        this.shopcontractFile = shopcontractFile;
    }
    /**
	 * 设置：签订商户
	 */
    public Integer getShanghuId() {
        return shanghuId;
    }


    /**
	 * 获取：签订商户
	 */

    public void setShanghuId(Integer shanghuId) {
        this.shanghuId = shanghuId;
    }
    /**
	 * 设置：签订时间
	 */
    public Date getShopcontractTime() {
        return shopcontractTime;
    }


    /**
	 * 获取：签订时间
	 */

    public void setShopcontractTime(Date shopcontractTime) {
        this.shopcontractTime = shopcontractTime;
    }
    /**
	 * 设置：备注
	 */
    public String getShopcontractContent() {
        return shopcontractContent;
    }


    /**
	 * 获取：备注
	 */

    public void setShopcontractContent(String shopcontractContent) {
        this.shopcontractContent = shopcontractContent;
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
        return "Shopcontract{" +
            "id=" + id +
            ", shopcontractName=" + shopcontractName +
            ", shopcontractFile=" + shopcontractFile +
            ", shanghuId=" + shanghuId +
            ", shopcontractTime=" + shopcontractTime +
            ", shopcontractContent=" + shopcontractContent +
            ", insertTime=" + insertTime +
        "}";
    }
}
