package com.ohmygod.shopagent.manage.controller;

import com.ohmygod.shopagent.manage.dto.VideoUploadDto;
import io.swagger.v3.oas.annotations.Operation;
import com.ohmygod.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/manage/video")
public class VideoManageController {

    @Operation(summary = "上传视频并投递解析任务")
    @PostMapping(value="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<Integer> upload(@RequestPart("file")MultipartFile file,
                                       @Valid @RequestPart(value="meta",required = false)VideoUploadDto videoUploadDto){
        return null;
    }
}
