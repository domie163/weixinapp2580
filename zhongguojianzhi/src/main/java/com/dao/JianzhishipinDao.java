package com.dao;

import com.entity.JianzhishipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianzhishipinView;

/**
 * 剪纸教学视频 Dao 接口
 *
 * @author 
 */
public interface JianzhishipinDao extends BaseMapper<JianzhishipinEntity> {

   List<JianzhishipinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
