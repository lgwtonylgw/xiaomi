package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserMapper {
    Integer insert(User user);
    User findByUsername(String username);
    User findUserByUsername(String username);
    User findUserById(Integer id);

    Integer updatePassword(
            @Param("id") Integer id,
            @Param("password") String password,
            @Param("modifiedTime") Date modifiedTime,
            @Param("modifiedUser") String modifiedUser);

    Integer updateInfo(User user);
    Integer addnew(User user);
    Integer updateQuestion(User user);
    Integer updateBcnumber(@Param("username") String username, @Param("bcnumber") String bcnumber, @Param("areas") String areas);
    Integer updateUserimg(@Param("id") Integer id, @Param("userimg") String userimg);
    Integer updateGrxx(@Param("username") String username,
                       @Param("nickname") String nickname,
                       @Param("birth") String birth,
                       @Param("gender") String gender);
}
