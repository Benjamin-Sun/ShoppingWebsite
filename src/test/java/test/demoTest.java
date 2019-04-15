package test;

import entity.User;
import repository.Conn;
import repository.IUserRepository;
import repository.IUserRepositoryXML;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}