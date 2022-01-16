package cn.delta1037.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_logBackupRestore")
public class BackupRestoreLog {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer logID;

    @Column
    private Date date;

    @Column
    private String type; // backup 还是 restore

    @Column
    private String source; // local 还是 remote

    public BackupRestoreLog(){
        this.date = new Date(System.currentTimeMillis());
        this.type = "default_type";
        this.source = "default_source";
    }

    public BackupRestoreLog(String type, String source){
        this.date = new Date(System.currentTimeMillis());
        this.type = type;
        this.source = source;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
