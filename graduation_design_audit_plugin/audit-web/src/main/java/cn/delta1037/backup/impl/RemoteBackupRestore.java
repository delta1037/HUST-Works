package cn.delta1037.backup.impl;

import cn.delta1037.backup.BackupRestoreBase;
import cn.delta1037.dao.impl.BackupRestoreDaoImpl;
import cn.delta1037.dao.impl.EventDaoImpl;
import cn.delta1037.entity.BackupRestoreLog;
import cn.delta1037.entity.Event;
import cn.delta1037.util.Context;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class RemoteBackupRestore implements BackupRestoreBase<Event> {
    // 事件数据库接口
    private EventDaoImpl remoteBREventDao = new EventDaoImpl();
    private BackupRestoreDaoImpl logDao = new BackupRestoreDaoImpl();

    private static RemoteBackupRestore _instance = null;
    public static RemoteBackupRestore instance(){
        if(_instance == null){
            _instance = new RemoteBackupRestore();
        }
        return _instance;
    }

    protected RemoteBackupRestore(){
        HibernateTemplate hibernateTemplate = (HibernateTemplate) Context.instance().getBean("backupToRemoteHibernateTemplate");
        remoteBREventDao.setHibernateTemplate(hibernateTemplate);
        logDao.setHibernateTemplate(hibernateTemplate);
    }

    @Override
    public void saveAll(List<Event> objects) {
        for(Event object : objects){
            remoteBREventDao.addEventNoRepeating(object);
        }
    }

    @Override
    public void deleteAll() {
        remoteBREventDao.deleteAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAll() {
        return remoteBREventDao.getAll();
    }

    @Override
    public void saveLog(Object o) {
        logDao.add((BackupRestoreLog) o);
    }

    @Override
    public List getAllLog() {
        return logDao.getAll();
    }
}
