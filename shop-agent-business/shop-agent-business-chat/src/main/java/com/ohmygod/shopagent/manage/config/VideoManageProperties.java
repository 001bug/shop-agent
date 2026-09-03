package com.ohmygod.shopagent.manage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.manage")
public class VideoManageProperties {

   // private
}
