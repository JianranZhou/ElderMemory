package elder.memory.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import elder.memory.utils.PageUtils;
import elder.memory.utils.R;
import elder.memory.entity.User;
import elder.memory.service.UserService;
import elder.memory.utils.MPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 *  frontend controller
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials ="true")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @GetMapping(value = "/login")
    public R login(String username, String password, HttpServletRequest request) {
        User user = userService.selectOne(new EntityWrapper<User>().eq("username", username));
        if(user==null || !user.getPassword().equals(password)) {
            return R.error("Incorrect username or password");
        }
        return R.ok().put("data",user);
    }
    /**
     * 注册
     */
    @PostMapping(value = "/register")
    public R register(@RequestBody User user, HttpSession session){
        if(userService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername())) !=null) {
            return R.error("User already exists");
        }
        userService.insert(user);
        //session.setAttribute("userId",user.getId());
        return R.ok();
    }

    /**
     * 完善
     */
    @PostMapping(value = "/complate")
    public R complate(@RequestBody User user, HttpSession session){
        //String uId = String.valueOf(session.getAttribute("user"));
        /*User oldUser = userService.selectById(request.getSession().getAttribute("userId").toString());
        oldUser.setAge(user.getAge());
        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        userService.updateById(oldUser);*/
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
    public R resetPass(String username, HttpServletRequest request){
        User user = userService.selectOne(new EntityWrapper<User>().eq("username", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        userService.update(user,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, User user){
        EntityWrapper<User> ew = new EntityWrapper<User>();
        PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list( User user){
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.allEq(MPUtil.allEQMapPre( user, "user"));
        return R.ok().put("data", userService.selectListView(ew));
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        User user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        User user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody User user){
//    	ValidatorUtils.validateEntity(user);
        if(userService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername())) !=null) {
            return R.error("用户已存在");
        }
        userService.insert(user);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody User user){
//        ValidatorUtils.validateEntity(user);
        User u = userService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()));
        if(u!=null && u.getId()!=user.getId() && u.getUsername().equals(user.getUsername())) {
            return R.error("用户名已存在。");
        }
        userService.updateById(user);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

