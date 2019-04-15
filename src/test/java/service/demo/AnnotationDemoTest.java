package service.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AnnotationDemoTest {

    @Test
    public void say() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationDemo annotationDemo = (AnnotationDemo) context.getBean("annotationDemo");

        annotationDemo.say();
    }
}