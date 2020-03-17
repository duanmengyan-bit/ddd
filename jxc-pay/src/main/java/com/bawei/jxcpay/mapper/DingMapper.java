package com.bawei.jxcpay.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bawei.jxcpay.entity.Ding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-07
 */
@Mapper
public interface DingMapper extends BaseMapper<Ding> {



    List<Ding> selectStu(@Param("i") int i);

    int updatee(Ding ding);

    void insertinto(Ding ding);
}
