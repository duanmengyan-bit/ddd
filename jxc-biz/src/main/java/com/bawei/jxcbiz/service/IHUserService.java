package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.HUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-16
 */
public interface IHUserService extends IService<HUser> {

    HUser getList(HUser user);
}
