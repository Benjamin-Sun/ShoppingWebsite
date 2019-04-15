package test;

import entity.User;
import repository.Conn;
import repository.IUserRepository;
import repository.IUserRepositoryXML;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * 目前作为service层使用
 */
public class demo {

    //获取session
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
    private IUserRepositoryXML userRepositoryXML = sqlSession.getMapper(IUserRepositoryXML.class);


    public static void main(String[] args) throws IOException {
//        System.out.println(new demo().xmlGetAll());
//        System.out.println(new demo().getAll());
    }

    public demo() throws IOException {
    }

    /**
     * 注解方式实现增删改查
     */
    public List<User> getAll(){
        List<User> list = userRepository.selectAll();
        //关闭session
        sqlSession.close();
        System.out.println(list);
        return list;
    }

    public User getById(int id){
        User user = userRepository.selectById(id);
        sqlSession.close();

        return user;
    }

    public Integer updateById(User user, int id){
        int i = userRepository.updateById(user, id);

        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    public Integer deleteById(int id){
        int i = userRepository.deleteById(id);

        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    /**
     * xml方式实现增删改查
     */
    public List<User> xmlGetAll(){
        List<User> list = userRepositoryXML.getAll();
        System.out.println(list);

        sqlSession.close();

        return list;
    }

    public Integer xmlInsert(User user){
//        User user = new User(
//                "benen",
//                "123456",
//                "11111111111",
//                "asda",
//                1);
        int i = userRepositoryXML.insert(user);

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    public Integer xmlUpdateById(User user, int id){
        int i = userRepositoryXML.updateById(user, id);

        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    public Integer xmlDeleteById(int id){
        int i = userRepositoryXML.deleteById(id);

        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    public List<User> getAllByXML(){

        List<User> list = sqlSession.selectList("getAll");
        System.out.println(list);

        sqlSession.close();

        return list;
    }
}
