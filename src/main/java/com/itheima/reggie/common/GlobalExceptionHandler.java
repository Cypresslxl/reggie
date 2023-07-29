package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
//这段代码是一个Spring Boot中的全局异常处理类，使用@ControllerAdvice注解来实现全局的异常处理。
//        它用于处理在Controller中抛出的异常，以便统一处理异常情况，并返回友好的错误信息给客户端。
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 关于SQL的异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在";
            return R.error(msg);
        }

        return R.error("未知错误");
    }

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());

        return R.error(ex.getMessage());
    }
}
//    这段代码是一个Spring Boot中的全局异常处理类，使用`@ControllerAdvice`注解来实现全局的异常处理。它用于处理在Controller中抛出的异常，以便统一处理异常情况，并返回友好的错误信息给客户端。
//
//        让我们逐步解释这段代码：
//
//        1. `@ControllerAdvice(annotations = {RestController.class, Controller.class})`：
//        - `@ControllerAdvice`注解表示这是一个全局异常处理类，用于处理Controller层抛出的异常。
//        - `annotations`属性用于指定要拦截的Controller注解类型，这里指定了`RestController`和`Controller`，表示该异常处理类会拦截标记有这两个注解的Controller类的异常。
//
//        2. `@ResponseBody`：
//        - `@ResponseBody`注解表示该类的所有处理方法的返回值会被直接写入HTTP响应体中，而不是跳转到其他页面。
//
//        3. `@Slf4j`：
//        - `@Slf4j`是Lombok提供的注解，用于自动生成日志记录器变量。
//
//        4. `public class GlobalExceptionHandler`：
//        - 这是一个普通的Java类，用于处理全局异常。
//
//        5. `@ExceptionHandler(SQLIntegrityConstraintViolationException.class)`：
//        - `@ExceptionHandler`注解表示该方法用于处理特定类型的异常。
//        - 在这里，`SQLIntegrityConstraintViolationException.class`表示该方法用于处理`SQLIntegrityConstraintViolationException`类型的异常。
//
//        6. `public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex)`：
//        - 这是处理`SQLIntegrityConstraintViolationException`异常的方法。
//        - `ex`参数表示捕获到的`SQLIntegrityConstraintViolationException`异常对象。
//
//        7. `log.error(ex.getMessage())`：
//        - 使用日志记录器记录异常信息。
//
//        8. `if(ex.getMessage().contains("Duplicate entry"))`：
//        - 这里对异常信息进行判断，判断是否为重复键值（Duplicate entry）异常。
//
//        9. `return R.error(msg)`：
//        - 如果是重复键值异常，则返回一个带有错误信息`msg`的自定义响应对象R。
//
//        10. `@ExceptionHandler(CustomException.class)`：
//        - 同样是`@ExceptionHandler`注解，这次是处理自定义异常`CustomException`类型的异常。
//
//        11. `public R<String> exceptionHandler(CustomException ex)`：
//        - 这是处理自定义异常的方法。
//        - `ex`参数表示捕获到的自定义异常对象。
//
//        12. `return R.error(ex.getMessage())`：
//        - 返回一个带有自定义异常信息的自定义响应对象R。
//
//        综上所述，这段代码是一个全局异常处理类，用于捕获不同类型的异常，并返回相应的错误信息，以便统一处理异常情况。它通过`@ControllerAdvice`注解来拦截Controller层抛出的异常，对不同类型的异常进行不同的处理，并将处理结果以JSON格式返回给客户端。
