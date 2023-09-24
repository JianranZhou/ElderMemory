package elder.memory.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import elder.memory.utils.PageUtils;
import elder.memory.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService extends IService<User> {


        PageUtils queryPage(Map<String, Object> params);

        List<User> selectListView(Wrapper<User> wrapper);

        PageUtils queryPage(Map<String, Object> params, Wrapper<User> wrapper);
}
