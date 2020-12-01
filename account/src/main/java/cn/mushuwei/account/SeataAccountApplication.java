package cn.mushuwei.account;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:07 下午
 */
@SpringBootApplication
@EnableDubbo
@MapperScan("cn.mushuwei.account.dao")
public class SeataAccountApplication {

    public static void main(String[] args) {

        SpringApplication.run(SeataAccountApplication.class);

    }
}
