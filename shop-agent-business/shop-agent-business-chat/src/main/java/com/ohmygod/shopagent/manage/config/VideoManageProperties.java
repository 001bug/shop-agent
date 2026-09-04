package com.ohmygod.shopagent.manage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.manage")
public class VideoManageProperties {

   private Minio minio = new Minio();
    @Data
    public static class Minio {
        private String endpoint = "http://127.0.0.1:9000";
        private String accessKey = "minioadmin";
        private String secretKey = "minioadmin";
        private String bucketName = "shop-agent-pro-document";
        private String objectPrefix = "rag/document";
        private String parsedTextPrefix = "rag/parsed-text";
        private String parseArtifactPrefix = "rag/parse-artifact";
    }
}
