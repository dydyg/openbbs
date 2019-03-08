package com.hc.openbbs;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hc.openbbs.mapper")
public class  OpenbbsApplication{

    public static void main(String[] args) {
        SpringApplication.run(OpenbbsApplication.class, args);
    }
}
