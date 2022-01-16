package cn.delta1037.AuditDataManage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:audit-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditDataManageTest {
    @Test
    public void backupData() {
        AuditDataManage auditDataManage = new AuditDataManage();
        auditDataManage.backupData();
    }

    @Test
    public void restoreData() {
        AuditDataManage auditDataManage = new AuditDataManage();
        auditDataManage.restoreData();
    }

    @Test
    public void exportData() {
        AuditDataManage auditDataManage = new AuditDataManage();
        auditDataManage.exportData("audit_data.log");
    }
}
