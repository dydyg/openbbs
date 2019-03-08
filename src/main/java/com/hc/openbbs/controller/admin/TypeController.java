package com.hc.openbbs.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Type;
import com.hc.openbbs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 17:18
 * @desc 分类管理额api
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {
    /**
     * 使用注解注入service TypeServiceImpl类 接口TypeService接收
     */
    @Autowired
    private TypeService typeService;

    /**
     * 获取列表
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/typesList")
   public Object getTypeList(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="10") int pageSize, Model model){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Type> TypeList=typeService.getTypeList(pageNum,pageSize);
        PageInfo<Type> p=new PageInfo<Type>(TypeList);
        model.addAttribute("page",p);
        model.addAttribute("typeList",TypeList);
       return "/admin/types.html";

   }

    /**
     * 新增分类页面
     *
     * @return
     */
    @GetMapping("/types/typesInput")
    public String input() {
        //model.addAttribute("type",typeList);
        return "/admin/typesInput.html";
    }

    /**
     * 新增分类数据
     * @param typeName
     * @return
     */
    @PostMapping("/types/typesInput/addType")
    public Object addType(String typeName,Model model) {
        int num=typeService.addType(new Type(typeName));
        if (num>0) {
            model.addAttribute("message", "新增成功!");
        } else {
            model.addAttribute("message", "新增失败!");
        }
        return "/admin/typesInput.html";
    }

    /**
     * 根据id 删除分类
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/deletebyid")
    public String delete(@RequestParam Long id,@RequestParam(required=true,defaultValue="1") int pageNum,Model model) {
        int num=typeService.deleteTypeById(id);
        if(num>0){model.addAttribute("message", "删除成功!");}else{model.addAttribute("message", "删除失败!");}
        return "/admin/typesList?pageNum="+pageNum;
    }
}
