package cn.delta1037.dao;

import cn.delta1037.entity.BackupRestoreLog;

import java.util.List;

public interface BackupRestoreDao {
    public void add(BackupRestoreLog backupRestoreLog);

    public List getAll();
}
