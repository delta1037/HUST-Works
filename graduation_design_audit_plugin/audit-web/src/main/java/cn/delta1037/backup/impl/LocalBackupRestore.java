package cn.delta1037.backup.impl;

import cn.delta1037.backup.BackupRestoreBase;
import cn.delta1037.dao.impl.BackupRestoreDaoImpl;
import cn.delta1037.dao.impl.EventDaoImpl;
import cn.delta1037.entity.BackupRestoreLog;
import cn.delta1037.entity.Event;
import cn.delta1037.util.Context;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class LocalBackupRestore implements BackupRestoreBase<Event> {
    // 事件数据库接口
    private EventDaoImpl localBREventDao = new EventDaoImpl();
    private BackupRestoreDaoImpl logDao = new BackupRestoreDaoImpl();

    private static LocalBackupRestore _instance = null;
    public static LocalBackupRestore instance(){
        if(_instance == null){
            _instance = new LocalBackupRestore();
        }
        return _instance;
    }

    protected LocalBackupRestore(){
        HibernateTemplate hibernateTemplate = (HibernateTemplate) Context.instance().getBean("backupToLocalHibernateTemplate");
        localBREventDao.setHibernateTemplate(hibernateTemplate);
        logDao.setHibernateTemplate(hibernateTemplate);
    }

    @Override
    public void saveAll(List<Event> objects) {
        for(Event object : objects){
            localBREventDao.addEventNoRepeating(object);
        }
    }

    @Override
    public void deleteAll() {
        localBREventDao.deleteAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAll() {
        return localBREventDao.getAll();
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
