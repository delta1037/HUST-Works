package cn.delta1037.AuditDataManage;

import cn.delta1037.AuditLogger.AuditQuery;
import cn.delta1037.AuditLogger.LoggerManage;
import cn.delta1037.backup.impl.LocalBackupRestore;
import cn.delta1037.backup.impl.RemoteBackupRestore;
import cn.delta1037.config.BackupConfig;
import cn.delta1037.entity.BackupRestoreLog;
import cn.delta1037.entity.Event;
import cn.delta1037.util.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AuditDataManage {
    private static AuditDataManage _instance = null;

    public static AuditDataManage instance(){
        if(_instance == null){
           _instance = new AuditDataManage();
        }
        return _instance;
    }
    // backup setting
    private static BackupConfig backupConfig = (BackupConfig) Context.instance().getBean("backup");

    protected AuditDataManage(){}

    public int getBackupToLocalRate(){
        return backupConfig.getBackupToLocalRate();
    }

    public int getBackupToRemoteRate(){
        return backupConfig.getBackupToRemoteRate();
    }

    public boolean getIsBackupToLocal(){
        return backupConfig.isBackupToLocal();
    }

    public boolean getIsBackupToRemote(){
        return backupConfig.isBackupToRemote();
    }

    public void backupData(){
        backupDataToLocal();
        backupDataToRemote();
    }

    public void backupDataToLocal(){
        if(!backupConfig.isBackupToLocal()){
            return;
        }

        BackupRestoreLog backupLocalLog = new BackupRestoreLog("backup" , "local");
        ArrayList<Event> events = AuditQuery.getAll();

        LocalBackupRestore.instance().saveAll(events);
        LocalBackupRestore.instance().saveLog(backupLocalLog);
    }

    public void backupDataToRemote(){
        if(!backupConfig.isBackupToRemote()){
            return;
        }

        BackupRestoreLog backupRemoteLog = new BackupRestoreLog("backup" , "remote");
        ArrayList<Event> events = AuditQuery.getAll();

        RemoteBackupRestore.instance().saveAll(events);
        RemoteBackupRestore.instance().saveLog(backupRemoteLog);
    }

    public void restoreData(){
        restoreDataFromLocal();
        restoreDataFromRemote();
    }

    public void restoreDataFromLocal(){
        if(!backupConfig.isBackupToLocal()){
            return;
        }
        BackupRestoreLog restoreLocalLog = new BackupRestoreLog("restore" , "local");
        ArrayList<Event> localEvents = (ArrayList<Event>) LocalBackupRestore.instance().getAll();

        restore(localEvents);
        LocalBackupRestore.instance().saveLog(restoreLocalLog);
    }

    public void restoreDataFromRemote(){
        if(!backupConfig.isBackupToRemote()){
            return;
        }
        BackupRestoreLog restoreRemoteLog = new BackupRestoreLog("restore" , "remote");
        ArrayList<Event> remoteEvents = (ArrayList<Event>) RemoteBackupRestore.instance().getAll();

        restore(remoteEvents);
        RemoteBackupRestore.instance().saveLog(restoreRemoteLog);
    }

    public void exportData(String exportPath){
        ArrayList<Event> events = AuditQuery.getAll();

        File fileWrite;
        try{
            fileWrite = new File(exportPath);
            fileWrite.createNewFile();

            BufferedWriter out = new BufferedWriter(new FileWriter(fileWrite));

            for(int i = 0; i < events.size(); ++i){
                out.write(events.get(i).getDate() + " " +
                        events.get(i).getEventType() + " " +
                        events.get(i).getSubject() + " " +
                        events.get(i).getObject() + " " +
                        events.get(i).getContent() + "\n");
            }

            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void restore(ArrayList<Event> events){
        for (Event event : events) {
            LoggerManage.instance().restoreEvent(event);
        }
    }
}
