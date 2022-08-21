package per.wsk.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wsk.bean.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wb_weishaokang
 * @date 2022/1/5 3:03 下午
 * @description
 */
@Controller
public class HttpController {

    /**
     * @RequestBody注解可以把多个请求参数，转成一个对象，然后将这个对象转成json字符串
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    /**
     * RequestEntity包含整个请求内容，包含请求头、请求体等
     * @param requestEntity
     * @return
     */
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEnity表示整个请求报文的信息
        System.out.println("请求头："+requestEntity.getHeaders());
        System.out.println("请求体："+requestEntity.getBody());
        return "success";
    }

//    请求头：[host:"localhost:8080", connection:"keep-alive", content-length:"46", cache-control:"max-age=0",
//    sec-ch-ua:"" Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97"", sec-ch-ua-mobile:"?0",
//    sec-ch-ua-platform:""macOS"", upgrade-insecure-requests:"1", origin:"http://localhost:8080",
//    user-agent:"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36",
//     accept:"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,
//    application/signed-exchange;v=b3;q=0.9", sec-fetch-site:"same-origin", sec-fetch-mode:"navigate", sec-fetch-user:"?1", " +
//            "sec-fetch-dest:"document", referer:"http://localhost:8080/springMVC_05/", accept-encoding:"gzip,
//             deflate, br", accept-language:"zh-CN,zh;q=0.9", Content-Type:"application/x-www-form-urlencoded;charset=UTF-8"]

//    请求体：username=reqteacdded&password=aaaaaadddddddddd
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,response");
    }

    /**
     * 该方法如果去掉@ResponseBody注解，会跳转到 成功.html页面
     * 如果加上@ResponseBody注解，会跳转到 空白页面，空白页面上面，只有 "成功" 这两个字
     * @return
     */
    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody(){
        return "成功";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody //该注解把下面的User对象，转成json字符串，输出到空白页面上，但需要配合json jar包一起使用
    public User testResponseUser(){
        return new User(1001, "admin", "123456", 23, "男");
    }


    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }

}
