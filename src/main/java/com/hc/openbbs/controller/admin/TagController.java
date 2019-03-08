package com.hc.openbbs.controller.admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Tag;
import com.hc.openbbs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by limi on 2017/10/16.
 */

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/TagList")
    public Object getTypeList(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="10") int pageSize, Model model){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> TagList=tagService.getTagList(pageNum,pageSize);
        PageInfo<Tag> p=new PageInfo<Tag>(TagList);
        model.addAttribute("page",p);
        model.addAttribute("TagList",TagList);
        return "/admin/tags.html";

    }

    /**
     * 新增编辑界面
     * @param model
     * @return
     */
    @GetMapping("/tags/addtag")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "/admin/tagsInput.html";
    }

    /**
     * 根据id编辑界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/tags/updatebyid")
    public String update(@RequestParam Long id,Model model) {
        model.addAttribute("tag", tagService.getTagById(id));
        return "/admin/tagsInput.html";
    }



    @PostMapping("/tags/add")
    public String post(Tag tag, BindingResult result, RedirectAttributes attributes) {
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        int t = tagService.addTag(tag);
        if (t == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/edit";
    }

    /**
     * 编辑
     * @param tag
     * @param result
     * @param id
     * @param attributes
     * @return
     */
    @PostMapping("/tags/edit")
    public String editPost(@Valid Tag tag, BindingResult result,@RequestParam Long id, RedirectAttributes attributes) {
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "/admin/tagsInput.html";
        }
        Tag t = tagService.updateTagById(id,tag.getName());
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/edit";
    }
    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/tag/deletebyid")
    public String delete(@RequestParam Long id,@RequestParam(required=true,defaultValue="1") int pageNum,Model model) {
        int num=tagService.deleteTagById(id);
        if(num>0){model.addAttribute("message", "删除成功!");}else{model.addAttribute("message", "删除失败!");}
        return "/admin/TagList?pageNum="+pageNum;
    }

}
