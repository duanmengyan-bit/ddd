package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.Ding;
import com.bawei.jxcbiz.mapper.DingMapper;
import com.bawei.jxcbiz.service.IDingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-07
 */
@Service
public class DingServiceImpl extends ServiceImpl<DingMapper, Ding> implements IDingService {



    @Override
    public List<Ding> selectStu(int i) {
        return this.baseMapper.selectStu(i);
    }

    @Override
    public int updatee(Ding ding) {
        return this.baseMapper.updatee(ding);
    }

    @Override
    public void insertinto(Ding ding) {
        this.baseMapper.insertinto(ding);
    }


}
