package com.yangpai.commodity.server.controller;

import com.yangpai.commodity.server.service.impl.MinioService;
import com.yangpai.conmon.component.ApiResult;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件上传控制器
 * @author kuangyoupeng1
 * @date 2022.3.15
 */
@RestController
@Slf4j
public class MinioController {
    /**
     * 文件服务类
     */
    @Resource
    private MinioService minioService;

    @PostMapping("commodity/pic/upload")
    public ApiResult upload(@RequestParam MultipartFile[] commodityPic){
        if (!minioService.upload(commodityPic)){
            return ApiResult.error("上传失败");
        }
        return ApiResult.success("上传成功");
    }

    @DeleteMapping("commodity/pic/upload")
    public ApiResult delete(@RequestParam List<String> removeList){
        if (!minioService.delete(removeList)){
            return ApiResult.error("删除失败");
        }
        return ApiResult.success("删除成功");
    }
}
