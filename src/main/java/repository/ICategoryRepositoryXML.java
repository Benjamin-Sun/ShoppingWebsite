package repository;

import entity.Category;
import org.apache.ibatis.annotations.Param;

public interface ICategoryRepositoryXML {
    public Category selectById(@Param("cid") int cid);
}
