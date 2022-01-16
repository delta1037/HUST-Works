package cn.delta1037.AuditLogger;

import cn.delta1037.entity.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@ContextConfiguration(locations = "classpath:audit-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditQueryTest {
    @Test
    public void getByCondition() {
        ArrayList<Event> list = AuditQuery.getByCondition(null, null, "", "", "", "");
        System.out.println("all list size : " + list.size());
    }

    @Test
    public void getByCondition1() {
        ArrayList<Event> list = AuditQuery.getByCondition(null, null, "INFO", "", "", "");
        System.out.println("info list size : " + list.size());
    }

    @Test
    public void getByCondition2() {
        ArrayList<Event> list = AuditQuery.getByCondition(null, null, "ERROR", "", "", "");
        System.out.println("error list size : " + list.size());
    }

    @Test
    public void getByCondition3() {
        ArrayList<Event> list = AuditQuery.getByCondition(null, null, "", "登录", "", "");
        System.out.println("logout type list size : " + list.size());
    }

    @Test
    public void getByCondition4() {
        ArrayList<Event> list = AuditQuery.getByCondition(null, null, "", "null", "", "");
        System.out.println("null type list size : " + list.size());
    }
}
