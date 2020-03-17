package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.TGoodstype;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
public interface TGoodstypeMapper extends BaseMapper<TGoodstype> {

    List getTree();
}
