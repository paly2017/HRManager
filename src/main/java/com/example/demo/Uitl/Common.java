package com.example.demo.Uitl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /***
     * 获取当前时间
     * @return
     */
    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /***
     * 返回数据存入时间格式时分秒
     * @return
     * @throws ParseException
     */
    public static Time getSqlTime() throws ParseException {
        String s = getDate();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=sp.parse(s);
        return new java.sql.Time(date.getTime());
    }

    /***
     * 返回数据库存入时间，年月日
     * @return
     * @throws ParseException
     */
    public static java.sql.Date getSqlDate() throws ParseException {
        String s = getDate();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=sp.parse(s);
        return new java.sql.Date(date.getTime());
    }

    public static Time getCheckTime(String time) throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat("HH:mm:ss");
        Date date = sp.parse(time);
        return new Time(date.getTime());
    }
}
