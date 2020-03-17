package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.Nation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-16
 */
public interface NationMapper extends BaseMapper<Nation> {

    List getList();
}
