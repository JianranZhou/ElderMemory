package elder.memory.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import elder.memory.entity.Admin;
import elder.memory.entity.User;
import elder.memory.utils.PageUtils;

import java.util.List;
import java.util.Map;


public interface AdminService extends IService<Admin> {


        PageUtils queryPage(Map<String, Object> params);

        List<Admin> selectListView(Wrapper<Admin> wrapper);

        PageUtils queryPage(Map<String, Object> params, Wrapper<Admin> wrapper);
}
