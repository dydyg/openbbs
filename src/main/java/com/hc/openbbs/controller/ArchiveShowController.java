package com.hc.openbbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.openbbs.entity.Diary;
import com.hc.openbbs.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yg
 * @create 2018-02-09 9:48
 * @desc 归档
 **/
@Controller
public class ArchiveShowController {
    @Autowired
    private BbsService bbsService;
    @GetMapping("/archives")
    public String archives(@RequestParam(required=true,defaultValue="1") int pageNum, @RequestParam(required=false,defaultValue="6") int pageSize, Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<Diary> diarys=bbsService.getBbsList(pageNum,pageSize);
        PageInfo<Diary> p=new PageInfo<Diary>(diarys);
        model.addAttribute("archivediary",diarys);
        model.addAttribute("page",p);
        return "/archives.html";
    }
}
