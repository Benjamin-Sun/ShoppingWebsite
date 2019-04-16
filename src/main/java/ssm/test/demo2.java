package ssm.test;

import org.springframework.beans.factory.annotation.Autowired;
import ssm.repository.IUserRepository;

public class demo2 {
    @Autowired
    IUserRepository iUserRepository;

    public static void main(String[] args) {
        System.out.println(new demo2().iUserRepository.selectAll());
    }
}
