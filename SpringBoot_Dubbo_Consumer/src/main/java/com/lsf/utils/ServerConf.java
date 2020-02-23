package com.lsf.utils;

import lombok.Data;
import org.apache.catalina.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2020/2/23.
 */
@Data
@Component
@ConfigurationProperties(prefix = "server")
public class ServerConf {

    private String port;
    private String contextPath;
}
