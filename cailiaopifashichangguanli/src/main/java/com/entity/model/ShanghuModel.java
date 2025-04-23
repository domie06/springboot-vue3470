package com.entity.model;

import com.entity.ShanghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShanghuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 商户姓名
     */
    private String shanghuName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 身份证号
     */
    private String shanghuIdNumber;


    /**
     * 手机号
     */
    private String shanghuPhone;


    /**
     * 邮箱
     */
    private String shanghuEmail;


    /**
     * 照片
     */
    private String shanghuPhoto;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：商户姓名
	 */
    public String getShanghuName() {
        return shanghuName;
    }


    /**
	 * 设置：商户姓名
	 */
    public void setShanghuName(String shanghuName) {
        this.shanghuName = shanghuName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：身份证号
	 */
    public String getShanghuIdNumber() {
        return shanghuIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setShanghuIdNumber(String shanghuIdNumber) {
        this.shanghuIdNumber = shanghuIdNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getShanghuPhone() {
        return shanghuPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setShanghuPhone(String shanghuPhone) {
        this.shanghuPhone = shanghuPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getShanghuEmail() {
        return shanghuEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setShanghuEmail(String shanghuEmail) {
        this.shanghuEmail = shanghuEmail;
    }
    /**
	 * 获取：照片
	 */
    public String getShanghuPhoto() {
        return shanghuPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setShanghuPhoto(String shanghuPhoto) {
        this.shanghuPhoto = shanghuPhoto;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
