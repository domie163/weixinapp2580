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
 * 剪纸教学视频
 *
 * @author 
 * @email
 */
@TableName("jianzhishipin")
public class JianzhishipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianzhishipinEntity() {

	}

	public JianzhishipinEntity(T t) {
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
     * 视频名称
     */
    @TableField(value = "jianzhishipin_name")

    private String jianzhishipinName;


    /**
     * 视频封面
     */
    @TableField(value = "jianzhishipin_photo")

    private String jianzhishipinPhoto;


    /**
     * 视频
     */
    @TableField(value = "jianzhishipin_video")

    private String jianzhishipinVideo;


    /**
     * 视频类型
     */
    @TableField(value = "jianzhishipin_types")

    private Integer jianzhishipinTypes;


    /**
     * 点击次数
     */
    @TableField(value = "jianzhishipin_clicknum")

    private Integer jianzhishipinClicknum;


    /**
     * 逻辑删除
     */
    @TableField(value = "jianzhishipin_delete")

    private Integer jianzhishipinDelete;


    /**
     * 视频简介
     */
    @TableField(value = "jianzhishipin_content")

    private String jianzhishipinContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：视频名称
	 */
    public String getJianzhishipinName() {
        return jianzhishipinName;
    }
    /**
	 * 获取：视频名称
	 */

    public void setJianzhishipinName(String jianzhishipinName) {
        this.jianzhishipinName = jianzhishipinName;
    }
    /**
	 * 设置：视频封面
	 */
    public String getJianzhishipinPhoto() {
        return jianzhishipinPhoto;
    }
    /**
	 * 获取：视频封面
	 */

    public void setJianzhishipinPhoto(String jianzhishipinPhoto) {
        this.jianzhishipinPhoto = jianzhishipinPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getJianzhishipinVideo() {
        return jianzhishipinVideo;
    }
    /**
	 * 获取：视频
	 */

    public void setJianzhishipinVideo(String jianzhishipinVideo) {
        this.jianzhishipinVideo = jianzhishipinVideo;
    }
    /**
	 * 设置：视频类型
	 */
    public Integer getJianzhishipinTypes() {
        return jianzhishipinTypes;
    }
    /**
	 * 获取：视频类型
	 */

    public void setJianzhishipinTypes(Integer jianzhishipinTypes) {
        this.jianzhishipinTypes = jianzhishipinTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getJianzhishipinClicknum() {
        return jianzhishipinClicknum;
    }
    /**
	 * 获取：点击次数
	 */

    public void setJianzhishipinClicknum(Integer jianzhishipinClicknum) {
        this.jianzhishipinClicknum = jianzhishipinClicknum;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJianzhishipinDelete() {
        return jianzhishipinDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setJianzhishipinDelete(Integer jianzhishipinDelete) {
        this.jianzhishipinDelete = jianzhishipinDelete;
    }
    /**
	 * 设置：视频简介
	 */
    public String getJianzhishipinContent() {
        return jianzhishipinContent;
    }
    /**
	 * 获取：视频简介
	 */

    public void setJianzhishipinContent(String jianzhishipinContent) {
        this.jianzhishipinContent = jianzhishipinContent;
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

    @Override
    public String toString() {
        return "Jianzhishipin{" +
            "id=" + id +
            ", jianzhishipinName=" + jianzhishipinName +
            ", jianzhishipinPhoto=" + jianzhishipinPhoto +
            ", jianzhishipinVideo=" + jianzhishipinVideo +
            ", jianzhishipinTypes=" + jianzhishipinTypes +
            ", jianzhishipinClicknum=" + jianzhishipinClicknum +
            ", jianzhishipinDelete=" + jianzhishipinDelete +
            ", jianzhishipinContent=" + jianzhishipinContent +
            ", createTime=" + createTime +
        "}";
    }
}
