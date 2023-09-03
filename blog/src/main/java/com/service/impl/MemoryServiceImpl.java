
package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MemoryDao;
import com.entity.MemoryEntity;
import com.service.MemoryService;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * 老年人回忆service层
 */
@Service("MemoryService")
public class MemoryServiceImpl extends ServiceImpl<MemoryDao, MemoryEntity> implements MemoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemoryEntity> page = this.selectPage(
                new Query<MemoryEntity>(params).getPage(),
                new EntityWrapper<MemoryEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<MemoryEntity> selectListView(Wrapper<MemoryEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params,
                               Wrapper<MemoryEntity> wrapper) {
        Page<MemoryEntity> page =new Query<MemoryEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}



