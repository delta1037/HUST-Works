package cn.delta1037.AuditLogger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LoggerFactory {
    // AuditLogger 类映射单例
    private static final ConcurrentMap<String, AuditLogger> auditLoggers = new ConcurrentHashMap();

    // 获取单个实例
    static public AuditLogger getAuditLogger(String loggerName){
        AuditLogger instance = (AuditLogger)auditLoggers.get(loggerName);
        if(null != instance){
            return instance;
        }else{
            AuditLogger newInstance = new AuditLogger();
            AuditLogger oldInstance = auditLoggers.putIfAbsent(loggerName, newInstance);
            return oldInstance == null? newInstance:oldInstance;
        }
    }
}
