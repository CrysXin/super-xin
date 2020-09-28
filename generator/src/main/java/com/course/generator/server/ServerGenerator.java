package com.course.generator.server;

import com.course.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有服务端生成的代码 dto /service / controller
 * Created by ZHX on 2020/9/28.
 */
public class ServerGenerator {

    //com.course.business.controller.admin
//    static String MODULE = "business";
//    static String toDtoPath = "server\\src\\main\\java\\com\\course\\server\\dto\\";
    static String toServicePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    static String toControllerPath = "business\\src\\main\\java\\com\\course\\business\\controller\\admin\\";
    //static String generatorConfigPath = "server\\src\\main\\resources\\generator\\generatorConfig.xml";

//    static String toServicePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
//    static String toControllerPath = "business\\src\\main\\java\\com\\course\\business\\controller\\admin\\";

    public static void main(String[] args) throws IOException, TemplateException {

        String Domain = "Section";
        String domain ="section";
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);

        // 生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Domain + "Service.java", map);


        // 生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Domain + "Controller.java", map);
    }
}
