package com.ohmygod.shopagent.manage.service.impl;
import com.ohmygod.shopagent.manage.support.StoredObjectInfo;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.StrUtil;
import com.ohmygod.enums.VideoFileTypeEnum;
import com.ohmygod.enums.VideoManageCode;
import com.ohmygod.exception.ShopAgentFrameException;
import com.ohmygod.shopagent.uid.UidGenerator;
import com.ohmygod.shopagent.manage.dto.VideoUploadDto;
import com.ohmygod.shopagent.manage.service.VideoManageService;
import com.ohmygod.shopagent.manage.vo.VideoUploadVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class VideoManageServiceImpl implements VideoManageService {

    private final UidGenerator uidGenerator;

    public VideoManageServiceImpl(UidGenerator uidGenerator) {
        this.uidGenerator = uidGenerator;
    }
    @Override
    public VideoUploadVo upload(MultipartFile file, VideoUploadDto dto) {

        if(file == null || file.isEmpty()){
            throw new ShopAgentFrameException(VideoManageCode.EMPTY_VIDEO_CONTENT.getCode(),VideoManageCode.EMPTY_VIDEO_CONTENT.getMsg());
        }

        String originalFileName = file.getOriginalFilename();
        if(StrUtil.isBlank(originalFileName)){
            throw new ShopAgentFrameException(VideoManageCode.UNSUPPORTED_VIDEO_TYPE.getCode(), "上传视频缺少原始文件名，无法识别文件类型。");
        }
        VideoFileTypeEnum fileType = VideoFileTypeEnum.fromFileName(originalFileName);

        if(fileType==null){
            throw new ShopAgentFrameException(VideoManageCode.UNSUPPORTED_VIDEO_TYPE.getCode(), VideoManageCode.UNSUPPORTED_VIDEO_TYPE.getMsg());
        }

        byte[] fileBytes = getFileBytes(file);
        Long videoId = uidGenerator.getUid();

        //StoredObjectInfo storedObjectInfo=
        return null;
    }
    private byte[] getFileBytes(MultipartFile file){
        try{
            //当前上传链路会把整份视频读入 JVM 内存，不是流式转存
            return file.getBytes();
        }catch(IOException exception){
            throw new ShopAgentFrameException(exception, VideoManageCode.VIDEO_STORAGE_FAILED.getCode(), "读取上传视频内容失败: "+exception.getMessage());
        }
    }
}
