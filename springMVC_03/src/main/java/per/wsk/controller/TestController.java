package per.wsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wb_weishaokang
 * @date 2021/12/31 5:30 下午
 * @description
 */
@Controller
public class TestController {


    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }

}
