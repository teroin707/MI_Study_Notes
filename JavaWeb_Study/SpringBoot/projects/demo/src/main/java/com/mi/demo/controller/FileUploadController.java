package com.mi.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String uploadFile(String nickname, MultipartFile f, HttpServletRequest request) throws IOException {
        System.out.println("昵称：" + nickname);
        System.out.println("文件大小：" + f.getSize());
        System.out.println("文件名称：" + f.getOriginalFilename());
        System.out.println("文件类型：" + f.getContentType());
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);
        saveFile(f, path);
        return "上传成功";
    }
    public void saveFile(MultipartFile f, String path) throws IOException {
        File upDir = new File(path);
        if (!upDir.exists()) {
            upDir.mkdirs();
        }
        File file =new File(path + f.getOriginalFilename());
        f.transferTo(file);
    }
}
