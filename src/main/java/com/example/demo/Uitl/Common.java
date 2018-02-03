package com.example.demo.Uitl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Common {
    /***
     * 获取httpsession
     * @param request
     * @return
     */
    public static HttpSession getSession(HttpServletRequest request){
        if (request==null){
            return null;
        }
        return request.getSession();
    }
}
