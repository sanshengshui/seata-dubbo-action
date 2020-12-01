package cn.mushuwei.storage;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jamesmsw
 * @date 2020/11/30 7:40 下午
 */
@SpringBootApplication
@EnableDubbo
@MapperScan("cn.mushuwei.storage.dao")
public class SeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication.class);
    }
}
