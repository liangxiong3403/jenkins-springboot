package top.xiangqian.jenkins.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liangxiong
 * @Project
 * @Description
 * @Date 2022-06-14
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("hello")
    public String hello() {
        return "hello,world";
    }
}
