package com.entity.vo;

import com.entity.JianzhishipinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 剪纸教学视频
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianzhishipin")
public class JianzhishipinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间  show1 show2 photoShow
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
