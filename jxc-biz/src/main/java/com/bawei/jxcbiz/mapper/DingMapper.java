package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.Ding;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-07
 */
public interface DingMapper extends BaseMapper<Ding> {



    List<Ding> selectStu(int i);

    int updatee(Ding ding);

    void insertinto(Ding ding);
}
