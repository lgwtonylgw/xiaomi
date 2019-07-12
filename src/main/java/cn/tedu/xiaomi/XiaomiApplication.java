package cn.tedu.xiaomi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("cn.tedu.xiaomi.mapper")
@Configuration
@ServletComponentScan(basePackages = "cn.tedu.xiaomi.util")
public class XiaomiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaomiApplication.class, args);
    }
    @Bean
    public MultipartConfigElement getMultipartConfig(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        DataSize maxsize=DataSize.ofMegabytes(100L);
        factory.setMaxFileSize(maxsize);
        factory.setMaxRequestSize(maxsize);
        MultipartConfigElement element=factory.createMultipartConfig();
        return element;
    }
}
