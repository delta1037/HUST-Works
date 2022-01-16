package cn.delta1037.schedule;

import cn.delta1037.AuditDataManage.AuditDataManage;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class BackupSchedule implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(jobExecutionContext.getJobDetail().getName().equals("backupToLocal")){
            AuditDataManage.instance().backupDataToLocal();
        }else if(jobExecutionContext.getJobDetail().getName().equals("backupToRemote")) {
            AuditDataManage.instance().backupDataToRemote();
        }
    }

    public static void run(){
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            if((!AuditDataManage.instance().getIsBackupToLocal())
                    && (!AuditDataManage.instance().getIsBackupToRemote())){
                return;
            }

            if(AuditDataManage.instance().getIsBackupToLocal()){
                // new backup to local job
                JobDetail backupToLocal = new JobDetail("backupToLocal", Scheduler.DEFAULT_GROUP, BackupSchedule.class);

                // backup to local trigger
                SimpleTrigger backupToLocalTrigger = new SimpleTrigger("backupToLocalTrigger", Scheduler.DEFAULT_GROUP);
                backupToLocalTrigger.setStartTime(new Date(System.currentTimeMillis()));
                backupToLocalTrigger.setRepeatInterval(AuditDataManage.instance().getBackupToLocalRate() * 1000 * 60);
                backupToLocalTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);

                // add backup to local job
                scheduler.scheduleJob(backupToLocal, backupToLocalTrigger);
            }

            if(AuditDataManage.instance().getIsBackupToRemote()){
                // new backup to remote job
                JobDetail backupToRemote = new JobDetail("backupToRemote", Scheduler.DEFAULT_GROUP, BackupSchedule.class);

                // backup to remote trigger
                SimpleTrigger backupToRemoteTrigger = new SimpleTrigger("backupToRemoteTrigger", Scheduler.DEFAULT_GROUP);
                backupToRemoteTrigger.setStartTime(new Date(System.currentTimeMillis()));
                backupToRemoteTrigger.setRepeatInterval(AuditDataManage.instance().getBackupToRemoteRate() * 1000 * 60);
                backupToRemoteTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);

                // add backup to remote job
                scheduler.scheduleJob(backupToRemote, backupToRemoteTrigger);
            }

            // start scheduler
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
