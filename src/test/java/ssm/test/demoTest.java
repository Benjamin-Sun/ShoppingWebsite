package ssm.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ssm.entity.User;
import ssm.repository.Conn;
import ssm.repository.IUserRepository;
import ssm.repository.IUserRepositoryXML;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import ssm.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@ContextConfiguration("classpath:dean.xml")
@ComponentScan(basePackages = "ssm.service")
public class demoTest {
    @Test
    public void getAll() throws IOException {
        Conn conn = new Conn();
        List<User> list = new ArrayList<>();
        //获取session
        SqlSession sqlSession = conn.getSqlSession();

        try {
            IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
            list = userRepository.selectAll();
        } finally {
            //关闭session
            conn.closeSqlSession(sqlSession);
        }

        System.out.println(list);
    }

    @Test
    public void xmlGetAll() throws IOException {
        Conn conn = new Conn();
        List<User> list = new ArrayList<>();
        //获取session
        SqlSession sqlSession = conn.getSqlSession();

        try {
            IUserRepositoryXML userRepository = sqlSession.getMapper(IUserRepositoryXML.class);
            List<User> list1 = sqlSession.selectList("getAll");
            System.out.println(list1);

            list = userRepository.getAll();
        } finally {
            //关闭session
            conn.closeSqlSession(sqlSession);
        }

        System.out.println(list);
    }

    @Test
    public void xmlInsert() throws IOException {
        Conn conn = new Conn();
        //获取session
        SqlSession sqlSession = conn.getSqlSession();

        User user = new User("benen", "123456", "11111111111", "asda", 1);
        IUserRepositoryXML userRepositoryXML = sqlSession.getMapper(IUserRepositoryXML.class);
        int i = userRepositoryXML.insert(user);

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        System.out.println(i);
    }

    @Test
    public void xmlUpdateById() throws IOException {
        Conn conn = new Conn();
        SqlSession sqlSession = conn.getSqlSession();
        IUserRepositoryXML userRepositoryXML = sqlSession.getMapper(IUserRepositoryXML.class);

        User user = new User("bensdojfldsnen", "123456", "11111111111", "asda", 1);
        int i = userRepositoryXML.updateById(user, 7);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(i);
    }

    @Test
    public void xmlDeleteById() throws IOException {
        Conn conn = new Conn();
        SqlSession sqlSession = conn.getSqlSession();
        IUserRepositoryXML userRepositoryXML = sqlSession.getMapper(IUserRepositoryXML.class);

        int i = userRepositoryXML.deleteById(8);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(i);
    }

    @Test
    public void updateById() throws IOException {
        Conn conn = new Conn();
        SqlSession sqlSession = conn.getSqlSession();
        IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

        User user1 = new User("bensdojfldsnen", "123456", "11111111111", "asda", 1);
        int i = userRepository.updateById(user1, 7);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(i);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void getById() throws IOException {
        Conn conn = new Conn();
        SqlSession sqlSession = conn.getSqlSession();
        IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

        User user = userRepository.selectById(7);

        sqlSession.close();

        System.out.println(user);
    }

    @Autowired
    UserService userService;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void noxmlselect(){
        SqlSession session = sqlSessionFactory.openSession();
        IUserRepository u = session.getMapper(IUserRepository.class);
        System.out.println(u.selectAll());
//        userService.selectall();
    }
}