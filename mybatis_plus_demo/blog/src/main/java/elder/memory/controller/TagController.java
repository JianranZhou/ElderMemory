package elder.memory.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import elder.memory.entity.Tag;
import elder.memory.service.TagService;
import elder.memory.utils.MPUtil;
import elder.memory.utils.PageUtils;
import elder.memory.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * elder memory
 */
@RequestMapping("Tag")
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * elder list
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, Tag tag){
        EntityWrapper<Tag> ew = new EntityWrapper<Tag>();
        PageUtils page = tagService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, tag), params), params));
        return R.ok().put("data", page);
    }

    /**
     * tag
     */
    @RequestMapping("/list")
    public R list( Tag tag){
        EntityWrapper<Tag> ew = new EntityWrapper<Tag>();
        ew.allEq(MPUtil.allEQMapPre( tag, "tag"));
        return R.ok().put("data", tagService.selectListView(ew));
    }

    /**
     * explicit information
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        Tag tag = tagService.selectById(id);
        return R.ok().put("data", tag);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody Tag tag){
//    	ValidatorUtils.validateEntity(tag);
        if(tagService.selectOne(new EntityWrapper<Tag>().eq("username",tag.getName())) !=null) {
            return R.error("this memory already exist.");
        }
        tagService.insert(tag);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Tag tag){
//        ValidatorUtils.validateEntity(tag);
        Tag u = tagService.selectOne(new EntityWrapper<Tag>().eq("tagTitle", tag.getName()));
        if(u!=null && u.getId()!=tag.getId() && u.getName().equals(tag.getName())) {
            return R.error("This memory already exist");
        }
        tagService.updateById(tag);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tagService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
