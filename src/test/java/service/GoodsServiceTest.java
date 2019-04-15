package service;

import entity.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import repository.Conn;
import repository.IGoodsRepositoryXML;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GoodsServiceTest {

    @Test
    public void getByNameOrDesc() throws IOException {
        Conn conn = new Conn();
        SqlSession session = conn.getSqlSession();

        IGoodsRepositoryXML goodsRepositoryXML = session.getMapper(IGoodsRepositoryXML.class);
        System.out.println(goodsRepositoryXML.getByNameOrDesc(null, null));
        System.out.println(goodsRepositoryXML.getByNameOrDescT(null, null));

        session.close();
    }

    @Test
    public void update() {
    }

    @Test
    public void insert() throws IOException {
        SqlSession session = new Conn().getSqlSession();

        IGoodsRepositoryXML goodsRepositoryXML = session.getMapper(IGoodsRepositoryXML.class);
        Goods goods = new Goods(5, "njkdu", BigDecimal.valueOf(5), 4, "hofvnoifdh", 2);
        System.out.println(goodsRepositoryXML.insert(goods));

        session.commit();
        session.close();
    }
}