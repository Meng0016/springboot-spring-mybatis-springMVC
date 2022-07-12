package com.ydlclass.controller;

import com.ydlclass.common.R;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@RestController
public class FileController {

    @PostMapping("upload")
    public R upload(@RequestParam("file") CommonsMultipartFile file){
        //按时间分文件夹 防重名
        String originalFilename = file.getOriginalFilename();
        // 创建一个不重复的名
        String newFileName= UUID.randomUUID().toString()
                +originalFilename.substring(originalFilename.lastIndexOf("."));
        //数据库存储元数据
        MyFile myFile=new MyFile();
        myFile.setSize(file.getSize());
        myFile.setOriginalFilename(originalFilename);
        myFile.setUrl("F:/test/"+newFileName);

        try {
            file.transferTo(new File("F:/test/"+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return R.fail();
        }
        return R.success();
    }


    @GetMapping("/download2")
    public ResponseEntity<byte[]> download2(){
        try {
            String fileName = "楠老师.jpg";
            byte[] bytes = FileUtils.readFileToByteArray(new File("F:/test/"+fileName));
            HttpHeaders headers=new HttpHeaders();
            // Content-Disposition就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            headers.set("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity=new ResponseEntity<>(bytes,headers, HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }






    public static class MyFile{
        private Long id;
        private String originalFilename;
        private Long size;
        private String newFileName;
        private String LastModifyTime;
        private String url;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOriginalFilename() {
            return originalFilename;
        }

        public void setOriginalFilename(String originalFilename) {
            this.originalFilename = originalFilename;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public String getNewFileName() {
            return newFileName;
        }

        public void setNewFileName(String newFileName) {
            this.newFileName = newFileName;
        }

        public String getLastModifyTime() {
            return LastModifyTime;
        }

        public void setLastModifyTime(String lastModifyTime) {
            LastModifyTime = lastModifyTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
