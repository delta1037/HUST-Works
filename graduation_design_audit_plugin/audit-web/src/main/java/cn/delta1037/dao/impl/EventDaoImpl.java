package cn.delta1037.dao.impl;

import cn.delta1037.dao.EventDao;
import cn.delta1037.entity.Event;
import cn.delta1037.util.EventType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    private static final String GET_ALL = "from Event e";
    private static final String GET_BY_CONDITION = "from Event e where e.date = ? and e.eventType = ? and e.subject = ? and e.object = ? and e.content = ?";
    private static final String GET_BY_DATE = "from Event e where e.date between ? and ?";
    private static final String GET_BY_LEVEL = "from Event e where e.eventLevel LIKE %?%";
    private static final String GET_BY_TYPE = "from Event e where e.eventType LIKE %?%";
    private static final String GET_BY_OBJECT = "from Event e where e.object LIKE %?%";
    private static final String GET_BY_SUBJECT = "from Event e where e.subject LIKE %?%";
    private static final String FIND_BY_CONDITION= "from Event e where e.date between ? and ? and e.eventLevel like ? and e.eventTypeValue like ? and e.object like ? and e.subject like ?";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate t_hibernateTemplate) {
        this.hibernateTemplate = t_hibernateTemplate;
    }

    @Override
    public void addNewEvent(Event event) {
        getHibernateTemplate().save(event);
    }

    @Override
    public void addEventNoRepeating(Event event) {
        if(getEvent(event).size() == 0){
            getHibernateTemplate().save(event);
        }
    }

    @Override
    public void deleteAll(){
        getHibernateTemplate().clear();
    }

    @Override
    public List getEvent(Event event) {
        Object[] params = {event.getDate(), event.getEventType(), event.getSubject(), event.getObject(), event.getContent()};
        return getHibernateTemplate().find(GET_BY_CONDITION, params);
    }

    @Override
    public List getAll() {
        return getHibernateTemplate().find(GET_ALL);
    }

    @Override
    public List getByDate(Date begin, Date end) {
        Object[] params = {begin, end};
        return getHibernateTemplate().find(GET_BY_DATE, params);
    }

    @Override
    public List<Event> getByLevel(String eventLevel) {
        List list = getHibernateTemplate().find(GET_BY_LEVEL, eventLevel);
        return list;
    }

    @Override
    public List getByType(String eventType) {
        List list = getHibernateTemplate().find(GET_BY_TYPE, eventType);
        return list;
    }

    @Override
    public List getByObject(String object) {
        return getHibernateTemplate().find(GET_BY_OBJECT, object);
    }

    @Override
    public List getBySubject(String subject) {
        return getHibernateTemplate().find(GET_BY_SUBJECT, subject);
    }

    @Override
    public List getByCondition(Date begin, Date end, String eventLevel, String eventTypeValue, String object, String subject) {
        Object[] params = {begin, end, eventLevel, eventTypeValue, object, subject};
        return getHibernateTemplate().find(FIND_BY_CONDITION, params);
    }
}
