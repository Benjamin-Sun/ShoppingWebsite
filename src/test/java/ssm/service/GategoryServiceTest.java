package ssm.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import ssm.repository.Conn;
import ssm.repository.ICategoryRepositoryXML;

import java.io.IOException;

public class GategoryServiceTest {

    @Test
    public void selectById() throws IOException {
        SqlSession session = new Conn().getSqlSession();
        ICategoryRepositoryXML categoryRepositoryXML = session.getMapper(ICategoryRepositoryXML.class);

        System.out.println(categoryRepositoryXML.selectById(1));
        session.close();
    }
}