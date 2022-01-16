package cn.delta1037.query;

import cn.delta1037.dao.impl.EventDaoImpl;
import cn.delta1037.entity.Event;
import cn.delta1037.util.Context;
import cn.delta1037.util.EventType;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.Date;
import java.util.List;

/**
 * 封装EventDaoImpl，实现各类查询方法
 */
public class QueryEvent {
    private static QueryEvent _instance = null;
    public static QueryEvent instance(){
        if(_instance == null){
            _instance = new QueryEvent();
        }
        return _instance;
    }

    private EventDaoImpl eventDaoImpl = new EventDaoImpl();

    // 设置hibernate模板
    protected QueryEvent(){
        HibernateTemplate hibernateTemplate = (HibernateTemplate) Context.instance().getBean("hibernateTemplate");
        eventDaoImpl.setHibernateTemplate(hibernateTemplate);
    }

    public void setEventDao(EventDaoImpl eventDao) {
        this.eventDaoImpl = eventDao;
    }

    public EventDaoImpl getEventDao() {
        return eventDaoImpl;
    }

    @SuppressWarnings("unchecked")
    public List<Event> queryAll(){
        return (List<Event>) eventDaoImpl.getAll();
    }

    @SuppressWarnings("unchecked")
    public List<Event> queryByType(String eventType){
        return (List<Event>) eventDaoImpl.getByType(eventType);
    }

    @SuppressWarnings("unchecked")
    public List<Event> queryByDate(Date begin, Date end){
        return (List<Event>) eventDaoImpl.getByDate(begin,end);
    }

    @SuppressWarnings("unchecked")
    public List<Event> queryByObject(String object){
        return (List<Event>) eventDaoImpl.getByObject(object);
    }

    @SuppressWarnings("unchecked")
    public List<Event> queryBySubject(String subject){
        return (List<Event>) eventDaoImpl.getBySubject(subject);
    }

    @SuppressWarnings("unchecked")
    public List<Event> queryByCondition(Date begin, Date end, String eventLevel, String eventTypeValue, String subject, String object){
        Date t_begin = new Date(0);
        Date t_end = new Date(System.currentTimeMillis());
        String t_eventLevel = "%%";
        String t_eventTypeValue = "%%";
        String t_subject = "%%";
        String t_object = "%%";

        if(begin != null){
            t_begin = begin;
        }

        if(end != null){
            t_end = end;
        }

        if(eventLevel != null && eventLevel.length() > 0){
            t_eventLevel = "%" + eventLevel + "%";
        }

        if(eventTypeValue != null && eventTypeValue.length() > 0){
            t_eventTypeValue = "%" + eventTypeValue + "%";
        }

        if(subject != null && subject.length() > 0){
           t_subject = "%" + subject + "%";
        }

        if(object != null && object.length() > 0){
            t_object = "%" + object + "%";
        }
        return (List<Event>) eventDaoImpl.getByCondition(t_begin, t_end, t_eventLevel, t_eventTypeValue, t_object, t_subject);
    }
}
