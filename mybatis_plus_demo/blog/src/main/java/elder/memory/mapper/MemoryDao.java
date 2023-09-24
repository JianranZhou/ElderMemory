package elder.memory.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import elder.memory.entity.MemoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 老年人回忆
 */
public interface MemoryDao extends BaseMapper<MemoryEntity> {

    List<MemoryEntity> selectListView(@Param("ew") Wrapper<MemoryEntity> wrapper);

    List<MemoryEntity> selectListView(Pagination page, @Param("ew") Wrapper<MemoryEntity> wrapper);

}

