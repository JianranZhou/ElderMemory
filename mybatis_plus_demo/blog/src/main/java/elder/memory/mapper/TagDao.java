package elder.memory.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import elder.memory.entity.MemoryEntity;
import elder.memory.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 老年人回忆
 */
public interface TagDao extends BaseMapper<Tag> {

    List<Tag> selectListView(@Param("ew") Wrapper<Tag> wrapper);

    List<Tag> selectListView(Pagination page, @Param("ew") Wrapper<Tag> wrapper);

}

