package cn.delta1037.dao;

import cn.delta1037.entity.Event;
import cn.delta1037.util.EventType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface EventDao {
    /**
     * @param event 要添加的事件
     * @return 添加事件的结果
     */
    void addNewEvent(Event event);

    void addEventNoRepeating(Event event);

    public void deleteAll();

    List<Event> getEvent(Event event);
    /**
     * @return 返回所有事件记录
     */
    List<Event> getAll();

    /**
     * @param begin 开始时间
     * @param end   结束时间
     * @return 返回指定时间段内的记录
     */
    List<Event> getByDate(Date begin, Date end);

    /**
     * @param eventLevel 要查询的事件等级
     * @return 返回指定事件类型的记录
     */
    List<Event> getByLevel(String eventLevel);

    /**
     * @param eventType 要查询的事件类型
     * @return 返回指定事件类型的记录
     */
    List<Event> getByType(String eventType);

    /**
     * @param object 主体
     * @return 返回主体object的所有事件记录
     */
    List<Event> getByObject(String object);

    /**
     * @param subject 客体
     * @return 返回客体subject的所有事件记录
     */
    List<Event> getBySubject(String subject);

    /**
     * @param begin     开始时间
     * @param end       结束时间
     * @param eventType 事件类型
     * @param object    事件主体
     * @param subject   事件客体
     * @return
     */
    List<Event> getByCondition(Date begin, Date end, String eventLevel, String eventType, String object, String subject);
}
