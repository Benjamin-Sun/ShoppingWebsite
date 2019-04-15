package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.demo.DataType;
import service.demo.SpringDemo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class springDemoTest {

    @Test
    public void say() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringDemo springDemo = (SpringDemo) context.getBean("springDemo");

        springDemo.say();
    }

    @Test
    public void dataType(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        DataType dataType=(DataType) context.getBean("dataType");
        String[] array=dataType.getArray();
        for(String a:array) {
            System.out.println(a);
        }
        System.out.println("-----------------------------");
        List<String> lists=dataType.getLists();
        for(String a:lists) {
            System.out.println(a);
        }
        System.out.println("-----------------------------");

        Map<String ,String> map=dataType.getMap();

        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }
        System.out.println("-------------------------------");

        Properties properties=dataType.getProperties();
        System.out.println(properties.getProperty("driver"));
        System.out.println("------------------------------");
        System.out.println(dataType.getEmail());
    }
}