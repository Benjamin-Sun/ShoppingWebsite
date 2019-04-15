package entity;

import java.util.List;

public class Category {
    private int cid;
    private String cname;
    private List<Goods> goodsList;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Category(int cid, String cname, List<Goods> goodsList) {
        this.cid = cid;
        this.cname = cname;
        this.goodsList = goodsList;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
