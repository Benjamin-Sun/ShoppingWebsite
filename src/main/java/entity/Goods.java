package entity;

import java.math.BigDecimal;

public class Goods {
    private int gid;
    private int gnum;
    private String gname;
    private BigDecimal gprice;
    private int gstock;
    private String gdesc;
    private int cid;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public int getGstock() {
        return gstock;
    }

    public void setGstock(int gstock) {
        this.gstock = gstock;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Goods(int gid, int gnum, String gname, BigDecimal gprice, int gstock, String gdesc, int cid) {
        this.gid = gid;
        this.gnum = gnum;
        this.gname = gname;
        this.gprice = gprice;
        this.gstock = gstock;
        this.gdesc = gdesc;
        this.cid = cid;
    }

    public Goods() {
    }

    public Goods(int gnum, String gname, BigDecimal gprice, int gstock, String gdesc, int cid) {
        this.gnum = gnum;
        this.gname = gname;
        this.gprice = gprice;
        this.gstock = gstock;
        this.gdesc = gdesc;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gnum=" + gnum +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gstock=" + gstock +
                ", gdesc='" + gdesc + '\'' +
                '}';
    }
}
