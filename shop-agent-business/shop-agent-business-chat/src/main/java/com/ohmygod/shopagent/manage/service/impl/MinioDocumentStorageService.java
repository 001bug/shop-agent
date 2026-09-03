package com.ohmygod.shopagent.manage.service.impl;
import com.ohmygod.shopagent.manage.service.VideoStorageService;
import com.ohmygod.shopagent.manage.support.StoredObjectInfo;
import io.minio.MinioClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class MinioDocumentStorageService implements VideoStorageService {

    //private final MinioClient minioClient;
    @Override
    public StoredObjectInfo uploadOriginalFile(Long documentId, String originalFileName, byte[] bytes, String contentType) {

        return null;
    }
}
