package io.studio.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/12/1 9:25
 *
 * @Author:poboking
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/auth/authenticate/hello")
    public String sayHello(){
        return "upload";
    }
}
