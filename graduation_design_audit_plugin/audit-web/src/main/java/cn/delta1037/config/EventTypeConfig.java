package cn.delta1037.config;

import org.springframework.stereotype.Component;

@Component
public class EventTypeConfig {
    private String[] defaultEventType;
    private String[] defaultEventTypeValue;
    private String[] customEventType;
    private String[] customEventTypeValue;

    public void setCustomEventType(String[] customEventType) {
        this.customEventType = customEventType;
    }

    public String[] getCustomEventType() {
        return customEventType;
    }

    public void setDefaultEventType(String[] defaultEventType) {
        this.defaultEventType = defaultEventType;
    }

    public String[] getDefaultEventType() {
        return defaultEventType;
    }

    public void setDefaultEventTypeValue(String[] defaultEventTypeValue) {
        this.defaultEventTypeValue = defaultEventTypeValue;
    }

    public String[] getDefaultEventTypeValue() {
        return defaultEventTypeValue;
    }

    public void setCustomEventTypeValue(String[] customEventTypeValue) {
        this.customEventTypeValue = customEventTypeValue;
    }

    public String[] getCustomEventTypeValue() {
        return customEventTypeValue;
    }
}
