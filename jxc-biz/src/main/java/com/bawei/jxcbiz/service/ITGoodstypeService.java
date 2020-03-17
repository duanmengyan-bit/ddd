package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.TGoodstype;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
public interface ITGoodstypeService extends IService<TGoodstype> {

    List getTree();
}
