package service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import repository.Conn;
import repository.ICategoryRepositoryXML;

import java.io.IOException;

import static org.junit.Assert.*;

public class GategoryServiceTest {

    @Test
    public void selectById() throws IOException {
        SqlSession session = new Conn().getSqlSession();
        ICategoryRepositoryXML categoryRepositoryXML = session.getMapper(ICategoryRepositoryXML.class);

        System.out.println(categoryRepositoryXML.selectById(1));
        session.close();
    }
}