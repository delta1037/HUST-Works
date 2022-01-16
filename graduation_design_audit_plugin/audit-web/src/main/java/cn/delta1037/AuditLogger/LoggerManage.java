package cn.delta1037.AuditLogger;

import cn.delta1037.dao.impl.EventDaoImpl;
import cn.delta1037.entity.Event;
import cn.delta1037.schedule.BackupSchedule;
import cn.delta1037.util.Context;
import cn.delta1037.util.EventLevel;
import cn.delta1037.util.EventType;
import org.springframework.orm.hibernate3.HibernateTemplate;

//@Service
public class LoggerManage {
    // LogManage 唯一实例
    private static LoggerManage loggerManage = null;
    // 获取日志管理的单个实例
    public static LoggerManage instance(){
        if(loggerManage == null){
            loggerManage = new LoggerManage();

            // 启动定时任务
            BackupSchedule.run();
        }
        return loggerManage;
    }

    // 事件数据库接口
    private EventDaoImpl eventDaoImpl = new EventDaoImpl();

    // 设置hibernate模板
    protected LoggerManage(){
        HibernateTemplate hibernateTemplate = (HibernateTemplate) Context.instance().getBean("hibernateTemplate");
        eventDaoImpl.setHibernateTemplate(hibernateTemplate);
    }

    public void restoreEvent(Event event){
        eventDaoImpl.addEventNoRepeating(event);
    }

    public void logEvent(Event event){
        eventDaoImpl.addNewEvent(event);
    }

    public void logEvent(String eventLevel, String eventType, String subject, String object, String content){
        Event event = new Event(EventLevel.instance().getLevel(eventLevel), EventType.instance().getType(eventType), EventType.instance().getValue(eventType), subject, object, content);
        eventDaoImpl.addNewEvent(event);
    }
}
