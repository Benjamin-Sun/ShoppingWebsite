package ssm.service;

import ssm.entity.Category;
import org.apache.ibatis.session.SqlSession;
import ssm.repository.Conn;
import ssm.repository.ICategoryRepositoryXML;

import java.io.IOException;

public class GategoryService {
    private SqlSession sqlSession = new Conn().getSqlSession();
    private ICategoryRepositoryXML categoryRepositoryXML = sqlSession.getMapper(ICategoryRepositoryXML.class);

    public GategoryService() throws IOException {
    }

    public Category selectById(int id){
        Category category = categoryRepositoryXML.selectById(1);
        sqlSession.close();

        return category;
    }
}

