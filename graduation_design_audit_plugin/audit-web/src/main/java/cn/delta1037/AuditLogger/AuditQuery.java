package cn.delta1037.AuditLogger;

import cn.delta1037.entity.Event;
import cn.delta1037.query.QueryEvent;

import java.util.ArrayList;
import java.util.Date;

public class AuditQuery {
    public static ArrayList<Event> getAll(){
        return (ArrayList<Event>) QueryEvent.instance().queryAll();
    }

    public static ArrayList<Event> getByCondition(Date begin, Date end, String eventLevel, String eventTypeValue, String subject, String object){
        return (ArrayList<Event>) QueryEvent.instance().queryByCondition(begin, end, eventLevel, eventTypeValue, subject, object);
    }
}

