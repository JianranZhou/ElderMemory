package elder.memory.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import elder.memory.entity.MemoryEntity;
import elder.memory.entity.Tag;
import elder.memory.utils.PageUtils;

import java.util.List;
import java.util.Map;


/**
 * 老年人回忆
 */
public interface TagService extends IService<Tag> {
    PageUtils queryPage(Map<String, Object> params);

    List<Tag> selectListView(Wrapper<Tag> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<Tag> wrapper);

}