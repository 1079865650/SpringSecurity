
package com.sangeng.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Controller
public class BasicController {

    // http://127.0.0.1:8080/hello?name=lisi
    @RequestMapping("/hello")
    @ResponseBody
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
    // @ex相当于获取容器中bean的名字为ex的对象，然后再调用这个对象的hasAuthority方法
    public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/testCors")
    @ResponseBody
    // @ex相当于获取容器中bean的名字为ex的对象，然后再调用这个对象的hasAuthority方法
    public String testCors(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return "testCors " + name;
    }

}
