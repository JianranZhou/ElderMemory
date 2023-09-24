package elder.memory.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import elder.memory.entity.Admin;
import elder.memory.service.AdminService;
import elder.memory.utils.MPUtil;
import elder.memory.utils.PageUtils;
import elder.memory.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/*
 *  前端控制器

 */
@RestController
@RequestMapping("/admin")
@CrossOrigin(allowCredentials ="true")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     */
    @GetMapping(value = "/login")
    public R login(String Adminname, String password, HttpServletRequest request) {
        Admin admin = adminService.selectOne(new EntityWrapper<Admin>().eq("Adminname", Adminname));
        if(admin==null || !admin.getPassword().equals(password)) {
            return R.error("Incorrect name or password");
        }
        return R.ok().put("data",admin);
    }
    /**
     * 注册
     */
    @PostMapping(value = "/register")
    public R register(@RequestBody Admin admin, HttpSession session){
        if(adminService.selectOne(new EntityWrapper<Admin>().eq("Adminname", admin.getName())) !=null) {
            return R.error("Admin already exists");
        }
        adminService.insert(admin);
        //session.setAttribute("AdminId",Admin.getId());
        return R.ok();
    }



    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     */
    @RequestMapping(value = "/resetPass")
    public R resetPass(String name, HttpServletRequest request){
        Admin admin = adminService.selectOne(new EntityWrapper<Admin>().eq("name", name));
        if(admin==null) {
            return R.error("账号不存在");
        }
        admin.setPassword("123456");
        adminService.update(admin,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, Admin admin){
        EntityWrapper<Admin> ew = new EntityWrapper<Admin>();
        PageUtils page = adminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, admin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list( Admin admin){
        EntityWrapper<Admin> ew = new EntityWrapper<Admin>();
        ew.allEq(MPUtil.allEQMapPre( admin, "admin"));
        return R.ok().put("data", adminService.selectListView(ew));
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        Admin admin = adminService.selectById(id);
        return R.ok().put("data", admin);
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrAdmin(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("AdminId");
        Admin admin = adminService.selectById(id);
        return R.ok().put("data", admin);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody Admin admin){
//    	ValidatorUtils.validateEntity(Admin);
        if(adminService.selectOne(new EntityWrapper<Admin>().eq("Adminname", admin.getName())) !=null) {
            return R.error("用户已存在");
        }
        adminService.insert(admin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Admin admin){
//        ValidatorUtils.validateEntity(Admin);
        Admin u = adminService.selectOne(new EntityWrapper<Admin>().eq("name", admin.getName()));
        if(u!=null && u.getId()!=admin.getId() && u.getName().equals(admin.getName())) {
            return R.error("用户名已存在。");
        }
        adminService.updateById(admin);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        adminService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

