package cn.delta1037.util;


import cn.delta1037.config.EventTypeConfig;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 事件类型
 *  登录登出事件
 *  用户新增删除事件
 *  审计失败时间
 */
public class EventType {
    private static EventType _instance = null;
    private static final ConcurrentMap<String, String> eventTypeMap = new ConcurrentHashMap();

    public static EventType instance(){
        if(_instance == null){
            _instance = new EventType();
        }

        return _instance;
    }

    protected EventType(){
        register();
    }

    private void register(){
        eventTypeMap.clear();

        // get all event from bean
        EventTypeConfig eventTypeConfig = (EventTypeConfig) Context.instance().getBean("eventType");

        String [] defaultEventType = eventTypeConfig.getDefaultEventType();
        String [] defaultEventTypeValue = eventTypeConfig.getDefaultEventTypeValue();
        genEventTypeMap(defaultEventType, defaultEventTypeValue);

        String [] customEventType = eventTypeConfig.getCustomEventType();
        String [] customEventTypeValue = eventTypeConfig.getCustomEventTypeValue();
        genEventTypeMap(customEventType, customEventTypeValue);
    }

    private void genEventTypeMap(String[] eventType, String[] eventTypeValue) {
        for (int i = 0; i < eventType.length; ++i) {
            if(i < eventTypeValue.length){
                eventTypeMap.putIfAbsent(eventType[i], eventTypeValue[i]);
            } else {
                eventTypeMap.putIfAbsent(eventType[i], eventType[i]);
            }
        }
    }

    public boolean findType(String string) {
        return eventTypeMap.containsKey(string);
    }

    public String getType(String string) {
        if(string != null && findType(string)){
            return string;
        }else{
            return getDefaultType();
        }
    }

    public String getValue(String string){
        if(string == null){
            return getDefaultTypeValue();
        }

        String ret = eventTypeMap.get(string);
        if (ret != null) {
            return ret;
        } else {
            return getDefaultTypeValue();
        }
    }

    public static String getDefaultType(){
        return "NULL";
    }

    public static String getDefaultTypeValue(){
        return "NULL";
    }
}

