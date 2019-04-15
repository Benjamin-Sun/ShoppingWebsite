package repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 封装连接
 */
public class Conn {

    public SqlSession getSqlSession() throws IOException {
        //从xml中构建sessionFactory
        String resource = "mybatis_config.xml";
        //读取xml
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //打开session
//        SqlSession session = sqlSessionFactory.openSession(true); //打开自动提交
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }

    public SqlSession getSqlSession(Boolean bool) throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession(bool);
        return session;
    }

    public void closeSqlSession(SqlSession sqlSession){
        //关闭session
        sqlSession.close();
    }
}
