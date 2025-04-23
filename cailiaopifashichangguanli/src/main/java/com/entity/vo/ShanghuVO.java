package com.entity.vo;

import com.entity.ShanghuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shanghu")
public class ShanghuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 商户姓名
     */

    @TableField(value = "shanghu_name")
    private String shanghuName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 身份证号
     */

    @TableField(value = "shanghu_id_number")
    private String shanghuIdNumber;


    /**
     * 手机号
     */

    @TableField(value = "shanghu_phone")
    private String shanghuPhone;


    /**
     * 邮箱
     */

    @TableField(value = "shanghu_email")
    private String shanghuEmail;


    /**
     * 照片
     */

    @TableField(value = "shanghu_photo")
    private String shanghuPhoto;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：商户姓名
	 */
    public String getShanghuName() {
        return shanghuName;
    }


    /**
	 * 获取：商户姓名
	 */

    public void setShanghuName(String shanghuName) {
        this.shanghuName = shanghuName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：身份证号
	 */
    public String getShanghuIdNumber() {
        return shanghuIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setShanghuIdNumber(String shanghuIdNumber) {
        this.shanghuIdNumber = shanghuIdNumber;
    }
    /**
	 * 设置：手机号
	 */
    public String getShanghuPhone() {
        return shanghuPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setShanghuPhone(String shanghuPhone) {
        this.shanghuPhone = shanghuPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getShanghuEmail() {
        return shanghuEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setShanghuEmail(String shanghuEmail) {
        this.shanghuEmail = shanghuEmail;
    }
    /**
	 * 设置：照片
	 */
    public String getShanghuPhoto() {
        return shanghuPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setShanghuPhoto(String shanghuPhoto) {
        this.shanghuPhoto = shanghuPhoto;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
