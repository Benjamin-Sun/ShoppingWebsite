package repository;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserRepositoryXML {
    List<User> getAll();

    User getById(@Param("id") int id);

    Integer insert(@Param("user") User user);

    Integer updateById(@Param("user") User user, @Param("id") int id);

    Integer deleteById(@Param("id") int id);
}
