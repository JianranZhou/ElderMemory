package elder.memory.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import elder.memory.entity.Admin;
import elder.memory.entity.Admin;
import elder.memory.mapper.AdminDao;
import elder.memory.service.AdminService;
import elder.memory.utils.PageUtils;
import elder.memory.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shine
 * @since 2019-07-19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {



        @Override
        public PageUtils queryPage(Map<String, Object> params) {
            Page<Admin> page = this.selectPage(
                    new Query<Admin>(params).getPage(),
                    new EntityWrapper<Admin>()
            );
            return new PageUtils(page);
        }

        @Override
        public List<Admin> selectListView(Wrapper<Admin> wrapper) {
            return baseMapper.selectListView(wrapper);
        }

        @Override
        public PageUtils queryPage(Map<String, Object> params,
                Wrapper<Admin> wrapper) {
            Page<Admin> page =new Query<Admin>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
        }
}
