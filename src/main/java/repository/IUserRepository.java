package repository;

import entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserRepository {
    @Select("SELECT * FROM t_user")
//    当数据库字段名与实体类属性名不配对时进行配对，通过在sql语句中给字段起别名的方式
//    @Results(value = {
//            @Result(property = "", column = ""),
//            @Result()
//    }) //对应表里的字段,property为实体类属性，column为数据库字段
    List<User> selectAll();

    @Select("SELECT * FROM t_user WHERE uid = #{id}")
    User selectById(@Param("id") int id);

    @Insert("INSERT INTO t_user(uname, upwd, telephone, address, ulevel) " +
            "VALUES(#{user.uname}, #{user.upwd}, #{user.telephone}, #{user.address}, #{user.ulevel})")
    Integer insert(@Param("user") User user);

    @Update("UPDATE t_user SET uname = #{user.uname}, upwd = #{user.upwd}, telephone = #{user.telephone}, address = #{user.address}, ulevel = #{user.ulevel} " +
            "WHERE uid = #{id}")
    Integer updateById(@Param("user") User user, @Param("id") int id);

    @Delete("DELETE FROM t_user WHERE uid = #{id}")
    Integer deleteById(int id);
}
