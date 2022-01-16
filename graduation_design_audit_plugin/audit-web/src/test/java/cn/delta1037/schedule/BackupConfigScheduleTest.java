package cn.delta1037.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:audit-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BackupConfigScheduleTest {
    @Test
    public void backupScheduleTest() {
        BackupSchedule backupSchedule = new BackupSchedule();
        BackupSchedule.run();

        try {
            Thread.sleep(1000 * 60 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
