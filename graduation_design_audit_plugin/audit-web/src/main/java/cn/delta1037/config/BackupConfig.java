package cn.delta1037.config;

import org.springframework.stereotype.Component;

@Component
public class BackupConfig {
    private boolean backupToLocal;
    private boolean backupToRemote;
    private int backupToLocalRate;
    private int backupToRemoteRate;

    public void setBackupToLocal(boolean backupToLocal) {
        this.backupToLocal = backupToLocal;
    }

    public boolean isBackupToLocal() {
        return backupToLocal;
    }

    public void setBackupToRemote(boolean backupToRemote) {
        this.backupToRemote = backupToRemote;
    }

    public boolean isBackupToRemote() {
        return backupToRemote;
    }

    public void setBackupToLocalRate(int backupToLocalRate) {
        this.backupToLocalRate = backupToLocalRate;
    }

    public int getBackupToLocalRate() {
        return backupToLocalRate;
    }

    public void setBackupToRemoteRate(int backupToRemoteRate) {
        this.backupToRemoteRate = backupToRemoteRate;
    }

    public int getBackupToRemoteRate() {
        return backupToRemoteRate;
    }
}
