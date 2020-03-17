package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.Ding;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-07
 */
public interface IDingService extends IService<Ding> {



    List<Ding> selectStu(int i);

    int updatee(Ding ding);


    void insertinto(Ding ding);
}
