package cn.delta1037.backup;

import java.util.List;

public interface BackupRestoreBase<T> {
    public void saveAll(List<T> objects);

    public void deleteAll();

    public List<T> getAll();

    public void saveLog(Object o);

    public List getAllLog();
}
