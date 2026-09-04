package com.ohmygod.shopagent.manage.service.impl;
import cn.hutool.core.util.StrUtil;
import com.ohmygod.enums.VideoManageCode;
import com.ohmygod.exception.ShopAgentFrameException;
import com.ohmygod.shopagent.manage.config.VideoManageProperties;
import com.ohmygod.shopagent.manage.service.VideoStorageService;
import com.ohmygod.shopagent.manage.support.StoredObjectInfo;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;


@AllArgsConstructor
@Service
public class MinioDocumentStorageService implements VideoStorageService {

    private final MinioClient minioClient;

    private final VideoManageProperties properties;

    @Override
    public StoredObjectInfo uploadOriginalFile(Long documentId, String originalFileName, byte[] bytes, String contentType) {

        //时间戳避免同文件直接覆盖: 当前原始文件名未做路径字符清洗
        String objectName = properties.getMinio().getObjectPrefix()+"/"+ documentId+"/"+System.currentTimeMillis()+"-"+originalFileName;
        upload(objectName,bytes,contentType);
        return new StoredObjectInfo(properties.getMinio().getBucketName(),objectName,buildObjectUrl(objectName));
    }

    private void upload(String objectName,byte[] bytes,String contentType){
        try{
            ensureBucketExists();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(properties.getMinio().getBucketName())
                    .object(objectName)
                    .contentType(StrUtil.isNotBlank(contentType)?contentType:"application/octet-stream")
                    .stream(new ByteArrayInputStream(bytes),bytes.length,-1)
                    .build()
            );
        } catch (Exception exception) {
            throw new ShopAgentFrameException(exception,
                    VideoManageCode.VIDEO_STORAGE_FAILED.getCode(), "上传MinIO文件失败"+exception.getMessage());
        }
    }

    private void ensureBucketExists()throws Exception{
        if(!bucketExists()){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getMinio().getBucketName()).build());
        }
    }

    private boolean bucketExists() throws Exception{
        String bucektName = properties.getMinio().getBucketName();
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucektName).build());
    }

    private String buildObjectUrl(String objectName){
        String endpoint = properties.getMinio().getEndpoint();
        if(endpoint.endsWith("/")){
            endpoint = endpoint.substring(0, endpoint.length() - 1);
        }
        return endpoint + "/" + properties.getMinio().getBucketName() + "/" + objectName;
    }
}
