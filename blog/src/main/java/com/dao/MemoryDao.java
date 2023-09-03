package com.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MemoryEntity;

    /**
     * 老年人回忆
     */
    public interface MemoryDao extends BaseMapper<MemoryEntity> {

        List<MemoryEntity> selectListView(@Param("ew") Wrapper<MemoryEntity> wrapper);

        List<MemoryEntity> selectListView(Pagination page, @Param("ew") Wrapper<MemoryEntity> wrapper);

    }

