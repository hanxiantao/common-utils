package hxt.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by hxt
 * Date 2020/5/28 7:33 上午
 * Description 日期工具类
 */
public class DateUtil {

    /**
     * 获取某天的开始时间
     *
     * @param zonedDateTime
     * @return
     */
    public static ZonedDateTime getDayStartDate(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toLocalDate().atStartOfDay(zonedDateTime.getZone());
    }


    /**
     * 获取某天的结束时间(方便存数据库)
     *
     * @param zonedDateTime
     * @return
     */
    public static ZonedDateTime getDayEndDate(ZonedDateTime zonedDateTime) {
        LocalDateTime localDateTime = zonedDateTime.toLocalDate().atTime(23, 59, 59);
        return localDateTime.atZone(zonedDateTime.getZone());
    }

    /**
     * 计算两个日期相差天数
     *
     * @param start
     * @param end
     * @return
     */
    public static long daysBetween(ZonedDateTime start, ZonedDateTime end) {
        LocalDate startDate = start.toLocalDate();
        LocalDate endDate = end.toLocalDate();
        return startDate.until(endDate, ChronoUnit.DAYS);
    }


    /**
     * 获取当月第一天
     *
     * @param localDate
     * @return
     */
    public static LocalDate getThisMonthFirstDay(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取当月最后一天
     *
     * @param localDate
     * @return
     */
    public static LocalDate getThisMonthLastDay(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

}
