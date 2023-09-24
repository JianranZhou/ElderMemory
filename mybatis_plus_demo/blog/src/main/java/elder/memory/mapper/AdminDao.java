package elder.memory.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import elder.memory.entity.Admin;
import elder.memory.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AdminDao extends BaseMapper<Admin> {

    List<Admin> selectListView(@Param("ew") Wrapper<Admin> wrapper);

    List<Admin> selectListView(Pagination page, @Param("ew") Wrapper<Admin> wrapper);
}
