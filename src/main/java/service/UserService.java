package service;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import repository.Conn;
import repository.IUserRepository;

import java.io.IOException;
import java.util.List;

public class UserService {
    //获取session
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

    public UserService() throws IOException {
    }

    public List<User> getAll(){
        List<User> list = userRepository.selectAll();

        sqlSession.close();

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
}
