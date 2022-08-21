package per.wsk.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Date:2021/7/10
 * Author:ybc
 * Description:
 */
@ControllerAdvice //将当前类标识为异常处理的组件
public class ExceptionController {

    /**
     * 如果出现ArithmeticException或NullPointerException，会跳转到error.html页面
     * @param ex
     * @param model
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }

}
