package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.Nation;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-16
 */
public interface INationService extends IService<Nation> {

    List getList();
}
