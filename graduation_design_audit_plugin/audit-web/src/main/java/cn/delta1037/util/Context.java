package cn.delta1037.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
    private static Context _instance = null;
    private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:audit-web.xml");

    public static Context instance(){
        if(_instance == null){
            _instance = new Context();
        }
        return _instance;
    }

    public Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
