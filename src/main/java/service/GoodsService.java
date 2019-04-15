package service;

import entity.Goods;
import org.apache.ibatis.session.SqlSession;
import repository.Conn;
import repository.IGoodsRepositoryXML;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class GoodsService {
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IGoodsRepositoryXML goodsRepositoryXML = sqlSession.getMapper(IGoodsRepositoryXML.class);

    public GoodsService() throws IOException {
    }

    public List<Goods> getByNameOrDesc(String gname, String gdesc){
        List<Goods> goods = goodsRepositoryXML.getByNameOrDesc(gname, gdesc);

        sqlSession.close();
        return goods;
    }

    public Integer update(Goods goods, int gid){
        goods.setGname("hhh");
        goods.setGdesc("houvhs");
        goods.setCid(2);
        goods.setGnum(3);
        goods.setGprice(BigDecimal.valueOf(9));
        goods.setGstock(6);

        int i = goodsRepositoryXML.update(goods, 1);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    public Integer insert(Goods goods){
        int i = goodsRepositoryXML.insert(goods);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
