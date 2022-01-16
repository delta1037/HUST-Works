package cn.delta1037.AuditLogger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:audit-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditLoggerTest {
    // 解析内容测试
    @Test
    public void eventParser() {
        AuditLogger logger = AuditLogger.getLogger("AuditLoggerTest");
        logger.event("INFO", "LOGIN", "subject", "object",
                "username : %{}", new String[]{"name"});
    }

    // 非解析内容测试
    @Test
    public void eventNoParser() {
        AuditLogger logger = AuditLogger.getLogger("AuditLoggerTest");
        logger.event("INFO", "LOGIN", "subject", "object", "username no parser");
    }

    // 未知eventType测试
    @Test
    public void eventNoEventType() {
        AuditLogger logger = AuditLogger.getLogger("AuditLoggerTest");
        logger.event("WARN", "NO_TYPE", "subject", "object", "username no parser");
    }

    // 空type测试
    @Test
    public void eventEventTypeNull() {
        AuditLogger logger = AuditLogger.getLogger("AuditLoggerTest");
        logger.event("ERROR", null, "subject", "object", "username no parser");
    }

    // 空subject测试
    @Test
    public void eventSubjectNull() {
        AuditLogger logger = AuditLogger.getLogger("AuditLoggerTest");
        logger.event(null, "ADD_USER", null, "object", "username no parser");
    }

    // 空object测试
    @Test
    public void eventObjectNull() {
        AuditLogger logger = AuditLogger.getLogger("AuditLoggerTest");
        logger.event("NO_TYPE", "AUDIT_FAIL", "subject", null, "username no parser");
    }
}
