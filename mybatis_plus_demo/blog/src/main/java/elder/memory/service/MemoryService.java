package elder.memory.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import elder.memory.utils.PageUtils;
import elder.memory.entity.MemoryEntity;

import java.util.List;
import java.util.Map;


/**
 * 老年人回忆
 */
public interface MemoryService extends IService<MemoryEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<MemoryEntity> selectListView(Wrapper<MemoryEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<MemoryEntity> wrapper);

}