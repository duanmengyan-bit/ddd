package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.Nation;
import com.bawei.jxcbiz.mapper.NationMapper;
import com.bawei.jxcbiz.service.INationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-16
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Override
    public List getList() {
        return this.baseMapper.getList();
    }
}
