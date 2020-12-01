package cn.mushuwei.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:29 下午
 */
@SpringBootApplication
@EnableDubbo
public class SeataBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataBusinessApplication.class);
    }
}
