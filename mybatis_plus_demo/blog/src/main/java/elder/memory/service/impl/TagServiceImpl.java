
package elder.memory.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import elder.memory.entity.Tag;
import elder.memory.mapper.TagDao;
import elder.memory.service.MemoryService;
import elder.memory.service.TagService;
import elder.memory.utils.PageUtils;
import elder.memory.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 老年人回忆service层
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<Tag> page = this.selectPage(
                new Query<Tag>(params).getPage(),
                new EntityWrapper<Tag>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<Tag> selectListView(Wrapper<Tag> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params,
                               Wrapper<Tag> wrapper) {
        Page<Tag> page =new Query<Tag>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}



