package com.hc.openbbs.controller.admin;
import com.alibaba.fastjson.JSON;
import com.hc.openbbs.entity.UploadPictureResponse;
import com.hc.openbbs.mapper.UserMapper;
import com.hc.openbbs.service.impl.FileUploadServiceImpl;
import com.hc.openbbs.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * @author yg
 * @create 2018-02-02 9:18
 * @desc 文件控制类:用户头像剪切上传
 **/
@Controller
public class FileController {
    @Autowired
    FileUploadServiceImpl uploadService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ImageUtils imageUtils;


    /**
     * 实现图片上传
     * @param file
     * @param response
     */
    @RequestMapping(path = {"/file/updateHeadPicture"}, method = {RequestMethod.GET, RequestMethod.POST})
    public void index(@RequestParam("imagefile") MultipartFile file, HttpServletResponse response) {
        try {
            UploadPictureResponse uploadPictureResponse = uploadService.updateHeadPicture(file);
                 /*
                 设置编码格式，返回结果json结果，注意其中的对象转化为json字符串格式为:
                 {"message":"上传图片成功!","success":1,"url":"C:\\\\home\\\\myblog\\\\pic\\\\2f1b63bc4b654a27a7e0c1b1a0fb9270.png"}
                 所以前端可以直接读取success，message等信息
                 */
            response.setContentType( "application/json;charset=UTF-8");
            response.getWriter().write( JSON.toJSONString(uploadPictureResponse));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @RequestMapping(path= {"/image"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index1() {
        return "image";
    }

    /**
     * 按照用户名查找头像
     * @param username
     * @param response
     */
    /*@RequestMapping(path = {"/image/{username}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public void index1(@PathVariable("username") String username, HttpServletResponse response) {
        User user = userMapper.selectByUsername(username);
        try {
            //写到输出流
            response.setContentType("image/png");
            response.setCharacterEncoding("UTF-8");
            //BufferedOutputStream 是缓冲输出流,默认新建字节数组大小为8192的“缓冲输出流”
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(user.getHead());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 按照用户名查找头像，并提供缩放功能
     * @param username 用户名
     * @param width 要求图片的宽度
     * @param height 要求图片的高度
     * @param response
     */
   /* @RequestMapping(path = "/image/{username}/{width}/{height}")
    public void getPhotoById(@PathVariable("username") String username, @PathVariable("width") int width,
                             @PathVariable("height") int height, HttpServletResponse response) {
        User user = userMapper.selectByUsername(username);
        byte[] data = user.getHead();
        try {
            if (width > 0 && height > 0) {
                data = imageUtils.scaleImage(data, width, height);
            }
            response.setContentType("image/png");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
