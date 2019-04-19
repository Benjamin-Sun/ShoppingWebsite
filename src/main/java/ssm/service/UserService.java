package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.entity.User;
import org.apache.ibatis.session.SqlSession;
import ssm.repository.Conn;
import ssm.repository.IUserRepository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    //获取session
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

    @Resource
    private IUserRepository iuserRepository;

    public void selectall(){
        try {
            System.out.println(iuserRepository.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

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
