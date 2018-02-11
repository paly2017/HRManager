package com.example.demo.Log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class ControllerLog {
    private static final Logger logger = LoggerFactory.getLogger(ControllerLog.class);

    //设置切面
    @Pointcut("execution(public * com.example.demo.controls..*(..))")
    public void cut(){}
    @Pointcut("execution(public * com.example.demo.service..*(..))")
    public void servicecut(){}
    @Before("cut()")//在调用上面 @Pointcut标注的方法前执行以下方法
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //方法
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法，类名及方法名
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+'.'+
                        joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("cut()")//无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter(){
        logger.info("------end-------");
    }
    @AfterReturning(returning = "obj",pointcut = "cut()")//在调用上面 @Pointcut标注的方法后执行。用于获取返回值
    public void doAfterReturning(Object obj){
        if (obj!=null) logger.info("response={}",obj.toString());
    }
    @Before("servicecut()")
    public void serviceBerfore(JoinPoint joinPoint){
        logger.info("------------进入service层--------------");
        //类及访问的方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+'.'+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
        //
    }
    @After("servicecut()")
    public void serviceAfter(){
        logger.info("------------service--End--------------");
    }
    @AfterReturning(returning = "object",pointcut = "servicecut()")
    public void doServiceAfterReturning(Object object){
        logger.info("--------------service层返回值-------------------");
        if (object!=null)logger.info("response={}",object.toString());
    }

}
