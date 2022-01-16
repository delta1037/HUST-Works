package cn.delta1037.AuditLogger;

import cn.delta1037.util.Content;

public class AuditLogger {
    static public AuditLogger getLogger(Class  clazz){
        return LoggerFactory.getAuditLogger(clazz.getName());
    }

    static public AuditLogger getLogger(String className){
        return LoggerFactory.getAuditLogger(className);
    }

    public void event(String eventLevel, String eventType, String subject, String object, String format, String[] args){
        LoggerManage.instance().logEvent(eventLevel, eventType, subject, object, Content.Parser(format, args));
    }

    public void event(String eventLevel, String eventType, String subject, String object, String content){
        LoggerManage.instance().logEvent(eventLevel, eventType, subject, object, content);
    }
}
