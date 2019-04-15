package service.demo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AnnotationDemo {
    @Resource
    private SpringDemo2 springDemo2;

    public void say(){
        springDemo2.hello();
    }
}
