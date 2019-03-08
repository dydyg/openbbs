package com.hc.openbbs.service.impl;

import com.hc.openbbs.entity.UploadPictureResponse;
import com.hc.openbbs.mapper.UserMapper;
import com.hc.openbbs.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * @author yg
 * @create 2018-02-02 9:42
 * @desc 文件上传服务
 **/
@Service(value = "UploadService")
public class FileUploadServiceImpl {
    @Autowired
    ImageUtils imageUtils;

    @Autowired
    UserMapper userMapper;

    /**
     * 上传的头像统一都转换为了png格式，故不进行是否允许类型判断
     * @param file
     * @return
     * @throws IOException
     */
    public UploadPictureResponse updateHeadPicture(MultipartFile file) throws IOException {
        UploadPictureResponse uploadPictureResponse = new UploadPictureResponse();
        try {
            InputStream is = file.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(is);
            //更新数据库中的blob格式的head字段，返回1表示更新成功，返回0表示失败
            int success = userMapper.updateHead(1,bytes);
            //上面已经将输入流中的数据全部读完，故重新初始化
            is = file.getInputStream();
            //同时将图片保存到C:\\home\\myblog\\pic\\ 路径下，这里保存到文件夹只是演示作用，请根据需求决定将图片保存到数据库还是服务器文件夹
            //重新定义图片名称
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".png" ;
            //复制图片到指定目录
            /*Files.copy(is, new File(imageUtils.getPictureDir() + fileName).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);*/
            uploadPictureResponse.setSuccess(success);
            uploadPictureResponse.setMessage("上传图片成功!");
            uploadPictureResponse.setUrl(imageUtils.getPictureDir() + fileName);
            is.close();
            return uploadPictureResponse;
        } catch (Exception e) {
            // 请求失败时打印的异常的信息
            uploadPictureResponse.setSuccess(0);
            uploadPictureResponse.setMessage("服务器异常！");
            return uploadPictureResponse;
        }
    }
}
