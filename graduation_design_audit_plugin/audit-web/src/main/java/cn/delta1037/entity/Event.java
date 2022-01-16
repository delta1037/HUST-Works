package cn.delta1037.entity;

import cn.delta1037.util.*;

import javax.persistence.*;
import java.util.Date;

/**
 * t_event : eventID | Date | eventType | object | subject | content
 */
@Entity
@Table(name = "t_event")
public class Event {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer eventID;

    @Column
    private Date date;               // 事件的时间戳

    @Column
    private String eventLevel;      // 事件等级

    @Column
    private String eventType;       // 事件类型

    @Column
    private String eventTypeValue;  // 事件类型别名

    @Column
    private String subject;         // 事件主体

    @Column
    private String object;          // 事件客体

    @Column
    private String content;         // 事件内容

    public Event(){
        this.date = new Date(System.currentTimeMillis());
        this.eventLevel = EventLevel.getDefaultLevel();
        this.eventType = EventType.getDefaultType();
        this.eventTypeValue = EventType.getDefaultTypeValue();
        this.subject = SubjectType.getDefaultType();
        this.object = ObjectType.getDefaultType();
        this.content = Content.getDefaultContent();
    }

    public Event(
            String eventLevel,
            String eventType,
            String eventTypeValue,
            String subject,
            String object,
            String content){
        this.date = new Date(System.currentTimeMillis());

        if(eventLevel == null){
            this.eventLevel = EventLevel.getDefaultLevel();
        }else{
            this.eventLevel = eventLevel;
        }

        if(eventType == null){
            this.eventType = EventType.getDefaultType();
        }else{
            this.eventType = eventType;
        }

        if(eventTypeValue == null){
            this.eventTypeValue = EventType.getDefaultTypeValue();

        }else{
            this.eventTypeValue = eventTypeValue;
        }

        if(subject == null){
            this.subject = SubjectType.getDefaultType();
        }else{
            this.subject = subject;
        }

        if(object == null){
            this.object = ObjectType.getDefaultType();
        }else{
            this.object = object;
        }

        this.content = content;
    }

    public Event(
            Date timestamp,
            String eventLevel,
            String eventType,
            String eventTypeValue,
            String subject,
            String object,
            String content){
        this.date = timestamp;

        if(eventLevel == null){
            this.eventLevel = EventLevel.getDefaultLevel();
        }else{
            this.eventLevel = eventLevel;
        }

        if(eventType == null){
            this.eventType = EventType.getDefaultType();
        }else{
            this.eventType = eventType;
        }

        if(eventTypeValue == null){
            this.eventTypeValue = EventType.getDefaultTypeValue();

        }else{
            this.eventTypeValue = eventTypeValue;
        }

        this.eventTypeValue = EventType.instance().getValue(this.eventType);

        if(subject == null){
            this.subject = SubjectType.getDefaultType();
        }else{
            this.subject = subject;
        }

        if(object == null){
            this.object = ObjectType.getDefaultType();
        }else{
            this.object = object;
        }

        this.content = content;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(String eventLevel) {
        this.eventLevel = eventLevel;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeValue() {
        return eventTypeValue == null ? "" : eventTypeValue.toString();
    }

    public void setEventTypeValue(String eventTypeValue) {
        this.eventTypeValue = eventTypeValue;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
