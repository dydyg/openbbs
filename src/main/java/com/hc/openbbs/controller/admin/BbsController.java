package com.hc.openbbs.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.entity.User;
import com.hc.openbbs.service.BbsService;
import com.hc.openbbs.service.DiaryTagService;
import com.hc.openbbs.service.TagService;
import com.hc.openbbs.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yg
 * @create 2018-01-10 10:45
 * @desc 后台管理论坛页面访问
 **/
@Controller
@RequestMapping("/admin")
public class BbsController {
    @Autowired
    private BbsService bbsService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private DiaryTagService diarytagService;
    //yg个人不推荐这种写法：该类被加载意味着会浪费非必要的内存来保存该定量值
    //文章发布页
    private static final String INPUT = "/admin/diaryadd.html";
    //文章修改页
    private static final String UPDATEINPUT = "/admin/bbsInput.html";
    private static final String REDIRECT_LIST = "redirect:/admin/hcbbs";
    /**
     * 跳转到后台管理首页
     * @return
     */
    @GetMapping("/hcbbs")
    public String bbs(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="10") int pageSize, Model model){
        PageHelper.startPage(pageNum, pageSize);
        List<Diary> diaryList =bbsService.getBbsList(pageNum,pageSize);
        PageInfo<Diary> p=new PageInfo<Diary>(diaryList);
        model.addAttribute("page",p);
        model.addAttribute("bbsList", diaryList);
        return "/admin/bbs.html";
    }

    /**
     * 进入发布文章页面
     * @param model
     * @return
     */
    @GetMapping("/diary/add")
    public String input(Model model) {
        //获取分类、标签
        setTypeAndTag(model);
        //获取文章
       // model.addAttribute("bbs", new Diary());
        System.out.println("进入bbs文章发布页面!");
        return INPUT;
    }


    //保存新增文章
    @PostMapping("/diary/add")
    public String addDiary(Diary diary, RedirectAttributes attributes, HttpSession session) {
          Long userid=((User) session.getAttribute("user")).getId();
              //保存用户ID
              diary.setUserId(userid);
              int flag=0;
              flag=bbsService.addBbs(diary);
              //保存标签-将tags放入实体类tags :diary.getTagIds()-获取从表单传入到实体类的tagIds
              System.out.println("插入的文章，返回的ID值："+diary.getId());
              diarytagService.addDiaryTagByIds(diary.getId(),diary.getTagIds());
              if (flag == 0 ) {
                  attributes.addFlashAttribute("message", "操作失败");
              } else {
                  attributes.addFlashAttribute("message", "操作成功");
              }
              return "/admin/hcbbs";


    }


    //保存新增文章
    @PostMapping("/diary/myadd")
    public String addmyDiary(Diary diary, RedirectAttributes attributes, HttpSession session) {
        Long userid=((User) session.getAttribute("user")).getId();
        //保存用户ID
        diary.setUserId(userid);
        int flag=0;
        flag=bbsService.addBbs(diary);
        //保存标签-将tags放入实体类tags :diary.getTagIds()-获取从表单传入到实体类的tagIds
        System.out.println("插入的文章，返回的ID值："+diary.getId());
        diarytagService.addDiaryTagByIds(diary.getId(),diary.getTagIds());
        if (flag == 0 ) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/userinfo";


    }


    //保存修改文章
    @PostMapping("/diary/update")
    public String updateDiary(Diary diary, RedirectAttributes attributes, HttpSession session) {
            int dflag=0;
            dflag=bbsService.updateBbsById(diary);
            //保存标签-将tags放入实体类tags :diary.getTagIds()-获取从表单传入到实体类的tagIds
            diarytagService.updateDiaryTagByIds(diary.getId(),diary.getTagIds());
            if (dflag == 0 ) {
                attributes.addFlashAttribute("message", "操作失败");
            } else {
                attributes.addFlashAttribute("message", "操作成功");
            }
            return REDIRECT_LIST;

    }


    //保存修改文章-前台个人
    @PostMapping("/diary/myupdate")
    public String updatemyDiary(Diary diary, RedirectAttributes attributes, HttpSession session) {
        int dflag=0;
        dflag=bbsService.updateBbsById(diary);
        //保存标签-将tags放入实体类tags :diary.getTagIds()-获取从表单传入到实体类的tagIds
        diarytagService.updateDiaryTagByIds(diary.getId(),diary.getTagIds());
        if (dflag == 0 ) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/userinfo";

    }

    /**
     * 进入文章修改页面
     * @param model
     * @return
     */
    @GetMapping("/diary/updateById")
    public String updateById(@RequestParam Long id, Model model) {
        setTypeAndTag(model);
        Diary diary = bbsService.getBbsByIdandNoConvert(id);
        System.out.println("修改的文章值："+diary.toString());
        model.addAttribute("diary",diary);
        return UPDATEINPUT;

    }

    //分类、标签查询
    private void setTypeAndTag(Model model) {
        //暂时使用默认值，不提供后台设置
        model.addAttribute("types", typeService.getTypeList(1,1000));
        model.addAttribute("tags", tagService.getTagList(1,1000));
    }



    @GetMapping("/diary/delete")
    public String delete(@RequestParam Long id, RedirectAttributes attributes) {
        typeService.deleteTypeById(id);
        tagService.deleteTagById(id);
        bbsService.deleteBbsById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return REDIRECT_LIST;
    }

    @GetMapping("/mydiary/delete")
    public String mydelete(@RequestParam Long id, RedirectAttributes attributes) {
        typeService.deleteTypeById(id);
        tagService.deleteTagById(id);
        bbsService.deleteBbsById(id);
        attributes.addFlashAttribute("message", "删除成功!");
        return "redirect:/userinfo";
    }
    /*@RequestMapping("/all_diary")
    public String getAllDiary() {
        System.out.println("获取json前");
        List<Diary> l = bbsService.getBbsList(1,10);
        System.out.println("获取json后:"+l.toString());
        if (null != l) {
            System.out.println(null != l);
            String json = JSON.toJSONString(l);
            return json;
        }
        return "";
    }*/
}
