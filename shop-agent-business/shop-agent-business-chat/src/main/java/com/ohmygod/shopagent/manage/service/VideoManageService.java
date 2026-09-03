package com.ohmygod.shopagent.manage.service;

import com.ohmygod.shopagent.manage.dto.VideoUploadDto;
import com.ohmygod.shopagent.manage.vo.VideoUploadVo;
import org.springframework.web.multipart.MultipartFile;

public interface VideoManageService {
    VideoUploadVo upload(MultipartFile file, VideoUploadDto dto);
}
