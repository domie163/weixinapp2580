package com.entity.model;

import com.entity.JianzhishipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 剪纸教学视频
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianzhishipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 视频名称
     */
    private String jianzhishipinName;


    /**
     * 视频封面
     */
    private String jianzhishipinPhoto;


    /**
     * 视频
     */
    private String jianzhishipinVideo;


    /**
     * 视频类型
     */
    private Integer jianzhishipinTypes;


    /**
     * 点击次数
     */
    private Integer jianzhishipinClicknum;


    /**
     * 逻辑删除
     */
    private Integer jianzhishipinDelete;


    /**
     * 视频简介
     */
    private String jianzhishipinContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：视频名称
	 */
    public String getJianzhishipinName() {
        return jianzhishipinName;
    }


    /**
	 * 设置：视频名称
	 */
    public void setJianzhishipinName(String jianzhishipinName) {
        this.jianzhishipinName = jianzhishipinName;
    }
    /**
	 * 获取：视频封面
	 */
    public String getJianzhishipinPhoto() {
        return jianzhishipinPhoto;
    }


    /**
	 * 设置：视频封面
	 */
    public void setJianzhishipinPhoto(String jianzhishipinPhoto) {
        this.jianzhishipinPhoto = jianzhishipinPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getJianzhishipinVideo() {
        return jianzhishipinVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setJianzhishipinVideo(String jianzhishipinVideo) {
        this.jianzhishipinVideo = jianzhishipinVideo;
    }
    /**
	 * 获取：视频类型
	 */
    public Integer getJianzhishipinTypes() {
        return jianzhishipinTypes;
    }


    /**
	 * 设置：视频类型
	 */
    public void setJianzhishipinTypes(Integer jianzhishipinTypes) {
        this.jianzhishipinTypes = jianzhishipinTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getJianzhishipinClicknum() {
        return jianzhishipinClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setJianzhishipinClicknum(Integer jianzhishipinClicknum) {
        this.jianzhishipinClicknum = jianzhishipinClicknum;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJianzhishipinDelete() {
        return jianzhishipinDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJianzhishipinDelete(Integer jianzhishipinDelete) {
        this.jianzhishipinDelete = jianzhishipinDelete;
    }
    /**
	 * 获取：视频简介
	 */
    public String getJianzhishipinContent() {
        return jianzhishipinContent;
    }


    /**
	 * 设置：视频简介
	 */
    public void setJianzhishipinContent(String jianzhishipinContent) {
        this.jianzhishipinContent = jianzhishipinContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
