package com.qzj.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;


public abstract class DateUtils
{
    public static final String TIME_PATTERN = "HH:mm";
    
    public static final String STANDARD_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    public static final String STANDARD_DATETIMEPATTERN = "yyyyMMddHHmmss";
    
    public static final String STANDARD_DATE_TIME_PATTERN_SSS = "yyyy-MM-dd HH:mm:ss.sss";
    
    public static final String STANDARD_DATE_PATTERN = "yyyy-MM-dd";
    
    public static final String SHORT_DATE_PATTERN = "yyyyMMdd";
    
    public static final String STR_BEGIN_DATE_TIME = " 00:00:00";
    
    public static final String STR_END_DATE_TIME = " 23:59:59";
    
    public static final String DATE_TIME_PATTERN_ORDERNO = "yyMMdd";
    
    public static final String STANDARD_DATE_TIME_PATTERN_MM = "yyyy-MM-dd HH:mm";
    
    public static String dateToStrDefault(Date date)
    {
        return dateToStr(date, STANDARD_DATE_TIME_PATTERN);
    }
    
    public static String dateToStr(Date date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    
    public static String dateToStr1(String date, String format)
    {
        Date d = strToDate(date, format);
        
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(d);
    }
    
    public static Date strToDateDefault(String str)
    {
        return strToDate(str, STANDARD_DATE_TIME_PATTERN);
    }
    
    public static Date strToDate(String str, String fromat)
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat(fromat);
            return formatter.parse(str);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    public static long StrToLong(String str, String fromat)
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat(fromat);
            return formatter.parse(str).getTime();
        }
        catch (ParseException e)
        {
            return 0l;
        }
    }
    
    /**
     * @param monthDate 格式"2012-01"
     * @return
     */
    public static Date monthFirstDate(String monthDate)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(strToDate(monthDate, "yyyy-MM"));
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return ca.getTime();
    }
    
    /**
     * @param monthDate 格式"2012-01"
     * @return
     */
    public static Date monthLastDate(String monthDate)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(strToDate(monthDate, "yyyy-MM"));
        ca.add(Calendar.MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, -1);
        return ca.getTime();
    }
    
    public static String getYesterDay()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    public static String getToDay()
    {
        Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    public static String getToDay2()
    {
        Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }
    
    /**
     * @param strD1
     * @param strD2 
     * @param type 1:day;2:week;3:month;4:year
     * @return
     */
    public static Set<String> getBetweenDate(String strD1, String strD2, int type)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_PATTERN);
            Date d1 = sdf.parse(strD1);
            Date d2 = sdf.parse(strD2);
            GregorianCalendar[] ga = getBetweenDate(d1, d2);
            Set<String> result = new TreeSet<String>();
            for (GregorianCalendar e : ga)
            {
                switch (type)
                {
                    case 1:
                        String dMonth =
                            (e.get(Calendar.MONTH) + 1) >= 10 ? "" + (e.get(Calendar.MONTH) + 1) : "0"
                                + (e.get(Calendar.MONTH) + 1);
                        String dayOfMonth =
                            e.get(Calendar.DAY_OF_MONTH) >= 10 ? "" + e.get(Calendar.DAY_OF_MONTH) : "0"
                                + e.get(Calendar.DAY_OF_MONTH);
                        result.add(e.get(Calendar.YEAR) + "-" + dMonth + "-" + dayOfMonth);
                        break;
                    case 2:
                        result.add(e.get(Calendar.YEAR) + "-" + (e.get(Calendar.WEEK_OF_YEAR)));
                        break;
                    case 3:
                        String month =
                            (e.get(Calendar.MONTH) + 1) >= 10 ? "" + (e.get(Calendar.MONTH) + 1) : "0"
                                + (e.get(Calendar.MONTH) + 1);
                        result.add(e.get(Calendar.YEAR) + "-" + month);
                        break;
                    case 4:
                        result.add(e.get(Calendar.YEAR) + "");
                        break;
                    default:
                        break;
                }
            }
            return result;
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    private static GregorianCalendar[] getBetweenDate(Date d1, Date d2)
    {
        Vector<GregorianCalendar> v = new Vector<GregorianCalendar>();
        GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
        gc1.setTime(d1);
        gc2.setTime(d2);
        do
        {
            GregorianCalendar gc3 = (GregorianCalendar)gc1.clone();
            v.add(gc3);
            gc1.add(Calendar.DAY_OF_MONTH, 1);
        } while (!gc1.after(gc2));
        return v.toArray(new GregorianCalendar[v.size()]);
    }
    
    public static Date getNowAddByDay(int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }
    
    public static Date getAddByDay(Date date, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }
    
    /**
     * 设置结佣期时间，通过有效期和默认的结佣期天数比较
     * <功能详细描述>
     * @param day
     * @param compareEffectiveTime
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Date getEffectiveTime(Date resultBeginTime, int day, Date compareEffectiveTime)
    {
        Calendar cal = Calendar.getInstance();
        if (resultBeginTime == null)
        {
            cal.setTime(new Date());
        }
        else
        {
            cal.setTime(resultBeginTime);
        }
        cal.add(Calendar.DAY_OF_MONTH, day);
        if (compareEffectiveTime == null)
        {
            return cal.getTime();
        }
        if (cal.getTime().getTime() > compareEffectiveTime.getTime())
        {
            return compareEffectiveTime;
        }
        else
        {
            return cal.getTime();
        }
    }
    
    /**
     * 获取到期日期跟现在系统时间之间的天数
     * @param date 到期时间
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int getSurplusDays(Date date)
    {
        if (null == date)
            throw new IllegalArgumentException("时间为空");
        return (int)((date.getTime() - System.currentTimeMillis()) / 86400000L);
    }
    
    /**
     * 获取到期日期跟现在系统时间之间的小时数
     * @param date 到期时间
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static long getSurplusHours(Date date)
    {
        if (null == date)
            throw new IllegalArgumentException("时间为空");
        return (long)((date.getTime() - System.currentTimeMillis()) / (1000 * 60 * 60));
    }
    
    public static int getCustSurplusHours(int setTime, Date reachDate)
    {
        if (null == reachDate)
            throw new IllegalArgumentException("时间为空");
        return (int)(setTime - ((System.currentTimeMillis() - reachDate.getTime()) / 3600000L));
    }
    
    /**
     * 时间差的天数
     * end-start
     * @param startDate
     * @param endDate
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Long getDaysBetween(Date startDate, Date endDate)
    {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);
        
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }
    
    /**
     * 获取当天的小时数
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int getHoursOfDay()
    {
        Calendar calendars = Calendar.getInstance(Locale.CHINA);
        return calendars.get(Calendar.HOUR_OF_DAY);
        
    }
    
    /**
     * 获取上一周的开始时间和结束时间
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getOneWeekTime()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        
        Calendar bal = Calendar.getInstance();
        bal.add(Calendar.DATE, -7);
        //2017-07-31 - 2017-08-06
        String OneWeekStr = new SimpleDateFormat("yyyy-MM-dd").format(bal.getTime())+" - "+new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return OneWeekStr;
    }
    
    /**
     * 获取上一个月
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getLastMonthTime()
    {
        Calendar cal = Calendar.getInstance();
        // 显示年份  
        int year = cal.get(Calendar.YEAR);
        // 显示月份
        int month = cal.get(Calendar.MONTH); 
        //2017-7
        String LastMonthTime = year+"-"+month;
        
        return LastMonthTime;
    }
    
    /**
     * 当前时间的前多少个小时
     * 
     * @param ihour
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getBeforeHourTime(int ihour)
    {  
        String returnstr = "";  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);  
        SimpleDateFormat df = new SimpleDateFormat(STANDARD_DATE_TIME_PATTERN);  
        returnstr = df.format(calendar.getTime());  
        
        return returnstr;  
    }
    
    /**
     * 当前时间的前多少分钟
     * 
     * @param ihour
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getBeforeMinuteTime(String time,int imin)
    {  
        String returnstr = "";
        Date date = null;
        if(StringUtils.isBlank(time))
        {
            date = new Date();
        }
        else
        {
            date = strToDateDefault(time);            
        }
        Date newDate = new Date(date.getTime()-60000*imin);
        SimpleDateFormat df = new SimpleDateFormat(STANDARD_DATE_TIME_PATTERN);  
        returnstr = df.format(newDate.getTime());
        
        return returnstr;  
    }
    
    /**
     * 当前时间的前多少分钟
     * 
     * @param ihour
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getafterMinuteTime(String time,int imin)
    {  
        String returnstr = "";
        Date date = null;
        if(StringUtils.isBlank(time))
        {
            date = new Date();
        }
        else
        {
            date = strToDateDefault(time);            
        }
        Date newDate = new Date(date.getTime()+60000*imin);
        SimpleDateFormat df = new SimpleDateFormat(STANDARD_DATE_TIME_PATTERN);  
        returnstr = df.format(newDate.getTime());
        
        return returnstr;  
    }
    
    
    
    /**
     * 当前时间的前多少个小时
     * 
     * @param ihour
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getBeforeDayTime(int ihour)
    {  
        String returnstr = "";  
        Calendar calendar = Calendar.getInstance();  
        calendar.add(Calendar.DAY_OF_MONTH, -ihour);;  
        SimpleDateFormat df = new SimpleDateFormat(STANDARD_DATE_TIME_PATTERN);  
        returnstr = df.format(calendar.getTime());  
        
        return returnstr;  
    }
    
    
    public static void main(String[] args)
        throws IOException
    {
//        Date d = getAddByDay(new Date(), 2);
//        System.out.println(dateToStrDefault(d));
//        System.out.println(dateToStr(new Date(), STANDARD_DATE_TIME_PATTERN_SSS));
//        String date =  getOneWeekTime();
//        System.out.println(date);
//        String month =  getLastMonthTime();
//        System.out.println(month);
//        
//        String time =  getBeforeHourTime(13);
//        System.out.println(time);
//        
//        String time1 =  getBeforeDayTime(30);
//        System.out.println(time1);
//        String date = DateUtils.getToDay2();
//        if(StringUtils.isBlank(Constants.PLUG_IN_PATH))
//        {
//            return;
//        }
//        //路径拼接
//        String dataPath = Constants.PLUG_IN_PATH+"\\"+date+".db3";
//        System.out.println(dataPath);
        
    }
    
}
