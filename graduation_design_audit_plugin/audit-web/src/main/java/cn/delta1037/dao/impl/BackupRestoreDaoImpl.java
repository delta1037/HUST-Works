package cn.delta1037.dao.impl;

import cn.delta1037.dao.BackupRestoreDao;
import cn.delta1037.entity.BackupRestoreLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

public class BackupRestoreDaoImpl implements BackupRestoreDao {
    private static final String GET_ALL = "from BackupRestoreLog l";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate t_hibernateTemplate) {
        this.hibernateTemplate = t_hibernateTemplate;
    }

    @Override
    public void add(BackupRestoreLog backupRestoreLog) {
        getHibernateTemplate().save(backupRestoreLog);
    }

    @Override
    public List getAll() {
        return getHibernateTemplate().find(GET_ALL);
    }
}
