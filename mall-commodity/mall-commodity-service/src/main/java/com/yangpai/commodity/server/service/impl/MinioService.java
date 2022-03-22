package com.yangpai.commodity.server.service.impl;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * minio文件服务
 * @author kuangyoupeng1
 * @date 2022.3.16
 */
@Service("minioService")
@Slf4j
public class MinioService {
    /**
     * minio客户端
     */
    @Resource
    private MinioClient minioClient;

    /**
     * minio bucket
     */
    @Value("${spring.minio.bucketName}")
    private String bucketName;

    /**
     * minio文件批量上传
     * @param multipartFiles
     * @return
     */
    public boolean upload(MultipartFile[] multipartFiles){
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                PutObjectArgs objectArgs = PutObjectArgs.builder()
                        .object(multipartFile.getOriginalFilename())
                        .bucket(bucketName)
                        .contentType(multipartFile.getContentType())
                        .stream(multipartFile.getInputStream(), multipartFile.getSize(), -1)
                        .build();
                minioClient.putObject(objectArgs);
            }
        }catch (Exception e){
            log.error("minio文件上传出错:", e);
            return false;
        }
        return true;
    }

    /**
     * minio文件批量删除
     * @param removeList
     * @return
     */
    public boolean delete(List<String> removeList){
        try{
            for (String removeName : removeList) {
                RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(removeName)
                        .build();
                minioClient.removeObject(removeObjectArgs);
            }
        }catch (Exception e){
            log.error("minio文件删除出错", e);
            return false;
        }
        return true;
    }
}
