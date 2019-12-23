package com.fuke.controller;

import com.fuke.domain.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public JsonResult upload(@RequestParam(value = "user_header")MultipartFile file){
        //获取文件大小
        //获取文件类型
        String contentType = file.getContentType();
        System.out.println("文件类型"+contentType);
        if(!contentType.contains("image")){
            return new JsonResult(false,"请上传图片");
        }
        String path = "F:"+ File.separator+"xiaoDproject"+File.separator+"FirstBootDemo"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator;
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String name = UUID.randomUUID().toString()+substring;
        File file1 = new File(path+name);
        try {
            file.transferTo(file1);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"上传失败");
        }
        return new JsonResult(true,"上传成功");
    }
}
