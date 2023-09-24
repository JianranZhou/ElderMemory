package elder.memory.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import elder.memory.utils.PageUtils;
import elder.memory.utils.Query;
import elder.memory.entity.User;
import elder.memory.mapper.UserDao;
import elder.memory.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {



        @Override
        public PageUtils queryPage(Map<String, Object> params) {
            Page<User> page = this.selectPage(
                    new Query<User>(params).getPage(),
                    new EntityWrapper<User>()
            );
            return new PageUtils(page);
        }

        @Override
        public List<User> selectListView(Wrapper<User> wrapper) {
            return baseMapper.selectListView(wrapper);
        }

        @Override
        public PageUtils queryPage(Map<String, Object> params,
                Wrapper<User> wrapper) {
            Page<User> page =new Query<User>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
        }
}
