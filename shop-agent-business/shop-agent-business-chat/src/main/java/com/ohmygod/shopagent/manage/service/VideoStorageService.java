package com.ohmygod.shopagent.manage.service;

import com.ohmygod.shopagent.manage.support.StoredObjectInfo;

public interface VideoStorageService {
    StoredObjectInfo uploadOriginalFile(Long documentId, String originalFileName, byte[] bytes, String contentType);
}
