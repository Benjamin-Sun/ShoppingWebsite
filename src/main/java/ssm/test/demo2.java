package ssm.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import ssm.repository.IUserRepository;
import ssm.service.UserService;

@ComponentScan(basePackages = "ssm.service")
public class demo2 {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
       new demo2().get();
    }

    public void get(){
        try {
            System.out.println(userService.toString());
        } catch (Exception e){
            System.out.println("null");
        }
    }
}
