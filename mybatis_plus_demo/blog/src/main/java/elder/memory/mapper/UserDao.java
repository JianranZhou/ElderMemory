package elder.memory.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import elder.memory.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao extends BaseMapper<User> {

    List<User> selectListView(@Param("ew") Wrapper<User> wrapper);

    List<User> selectListView(Pagination page, @Param("ew") Wrapper<User> wrapper);
}
