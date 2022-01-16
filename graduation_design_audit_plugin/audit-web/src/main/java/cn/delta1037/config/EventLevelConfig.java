package cn.delta1037.config;

public class EventLevelConfig {
    private String[] defaultEventLevel;
    private String[] customEventLevel;

    public String[] getDefaultEventLevel() {
        return defaultEventLevel;
    }

    public void setDefaultEventLevel(String[] defaultEventLevel) {
        this.defaultEventLevel = defaultEventLevel;
    }

    public String[] getCustomEventLevel() {
        return customEventLevel;
    }

    public void setCustomEventLevel(String[] customEventLevel) {
        this.customEventLevel = customEventLevel;
    }
}
