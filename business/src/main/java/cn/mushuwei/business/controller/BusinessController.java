package cn.mushuwei.business.controller;

import cn.mushuwei.business.dto.BusinessDTO;
import cn.mushuwei.business.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:48 下午
 */
@RestController
@RequestMapping("/business")
@Slf4j
public class BusinessController {

    @Resource(name = "businessService")
    private BusinessService businessService;

    @PostMapping("/buy")
    public String handleBusiness(@RequestBody BusinessDTO businessDTO){
        log.info("请求参数：{}",businessDTO.toString());
        Boolean result = businessService.handleBusiness(businessDTO);
        if (result) {
            return "ok";
        }
        return "fail";
    }
}
