package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.HUser;
import com.bawei.jxcbiz.mapper.HUserMapper;
import com.bawei.jxcbiz.service.IHUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-16
 */
@Service
public class HUserServiceImpl extends ServiceImpl<HUserMapper, HUser> implements IHUserService {

    @Override
    public HUser getList(HUser user) {
        return this.baseMapper.getList(user);
    }
}
