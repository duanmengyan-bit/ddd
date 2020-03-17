package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.TGoods;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bawei.jxccommon.Dto.TGoodsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
public interface TGoodsMapper extends BaseMapper<TGoods> {

    List getList(TGoodsDto tGoodsDto);

    List getGoods(@Param("typeId") Integer typeId);
}
