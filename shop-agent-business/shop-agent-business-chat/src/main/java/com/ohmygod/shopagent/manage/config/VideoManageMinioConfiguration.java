package com.ohmygod.shopagent.manage.config;

import com.ohmygod.enums.VideoManageCode;
import com.ohmygod.exception.ShopAgentFrameException;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(VideoManageProperties.class)
public class VideoManageMinioConfiguration {

    @Bean
    public MinioClient videoMinioClient(VideoManageProperties properties){
        return MinioClient.builder()
                .endpoint(properties.getMinio().getEndpoint())
                .credentials(properties.getMinio().getAccessKey(),properties.getMinio().getSecretKey())
                .build();
    }

    public CommandLineRunner videoMinioBucketInitializer(MinioClient videoMinioClient,
                                                         VideoManageProperties properties){
        return args -> {
            String bucketName = properties.getMinio().getBucketName();
            try{
                boolean exists = videoMinioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
                if(!exists){
                    videoMinioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                    log.info("视频管理模块 MinIO bucket 不存在，已自动创建，bucket={}", bucketName);
                }else{
                    log.info("视频管理模块 MinIO bucket 已存在，bucket={}", bucketName);
                }
            }catch (Exception exception){
                throw new ShopAgentFrameException(exception, VideoManageCode.VIDEO_STORAGE_FAILED.getCode(), "初始化MinIO bucket失败:"
                                +exception.getMessage());
            }
        };
    }
}
