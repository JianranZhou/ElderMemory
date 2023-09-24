
package elder.memory.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import elder.memory.utils.PageUtils;
import elder.memory.utils.R;
import elder.memory.entity.MemoryEntity;
import elder.memory.service.MemoryService;
import elder.memory.utils.MPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 老年人回忆
 */
@RequestMapping("Memory")
@RestController
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    /**
     * 老年人列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, MemoryEntity memory){
        EntityWrapper<MemoryEntity> ew = new EntityWrapper<MemoryEntity>();
        PageUtils page = memoryService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, memory), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 老年人回忆列表
     */
    @RequestMapping("/list")
    public R list( MemoryEntity memory){
        EntityWrapper<MemoryEntity> ew = new EntityWrapper<MemoryEntity>();
        ew.allEq(MPUtil.allEQMapPre( memory, "memory"));
        return R.ok().put("data", memoryService.selectListView(ew));
    }

    /**
     * 回忆列表详情信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        MemoryEntity memory = memoryService.selectById(id);
        return R.ok().put("data", memory);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MemoryEntity memory){
//    	ValidatorUtils.validateEntity(memory);
        if(memoryService.selectOne(new EntityWrapper<MemoryEntity>().eq("username",memory.getMemoryTitle())) !=null) {
            return R.error("该老年人回忆已存在");
        }
       memoryService.insert(memory);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemoryEntity memory){
//        ValidatorUtils.validateEntity(memory);
        MemoryEntity u = memoryService.selectOne(new EntityWrapper<MemoryEntity>().eq("memoryTitle", memory.getMemoryTitle()));
        if(u!=null && u.getId()!=memory.getId() && u.getMemoryTitle().equals(memory.getMemoryTitle())) {
            return R.error("该老年人回忆已存在。");
        }
        memoryService.updateById(memory);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        memoryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
