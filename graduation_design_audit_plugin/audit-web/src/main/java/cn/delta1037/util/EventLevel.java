package cn.delta1037.util;

import cn.delta1037.config.EventLevelConfig;
import cn.delta1037.config.EventTypeConfig;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EventLevel {
    private static EventLevel _instance = null;
    private static final ConcurrentMap<String, String> eventLevelMap = new ConcurrentHashMap();

    public static EventLevel instance(){
        if(_instance == null){
            _instance = new EventLevel();
        }

        return _instance;
    }

    protected EventLevel(){
        register();
    }

    private void register(){
        eventLevelMap.clear();

        // get all event from bean
        EventLevelConfig eventLevelConfig = (EventLevelConfig) Context.instance().getBean("eventLevel");

        String[] defaultEventLevel = eventLevelConfig.getDefaultEventLevel();
        for(String string : defaultEventLevel){
            eventLevelMap.putIfAbsent(string, string);
        }

        String[] customEventLevel = eventLevelConfig.getCustomEventLevel();
        for(String string : customEventLevel){
            eventLevelMap.putIfAbsent(string, string);
        }
    }

    public String getLevel(String string){
        if(string !=null && eventLevelMap.containsKey(string)){
            return string;
        }else{
            return getDefaultLevel();
        }
    }

    public static String getDefaultLevel(){
        return "NULL";
    }

}
