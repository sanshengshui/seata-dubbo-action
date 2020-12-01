package cn.mushuwei.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jamesmsw
 * @date 2020/12/1 5:47 下午
 */
@SpringBootApplication
@EnableDubbo
@MapperScan("cn.mushuwei.order.dao")
public class SeataOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication.class);
    }
}
