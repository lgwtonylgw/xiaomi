package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.User;
import cn.tedu.xiaomi.service.ex.*;

public interface IUserService {
    void reg(User user) throws UsernameDuplicateException, InsertException;
    void SendEmail(String email,String checkCode) throws EmailNotSendException;
    void check(String emailCode,String checkCode) throws EmailCodeWrongException;
    User login(String username,String password) throws UserNotFoundException, PasswordNotMatchException;
    User findByUsername(String username) throws UserNotFoundException;
    void changeAvatar(Integer id, String userimg)
            throws UserNotFoundException,
            UpdateException;
    User findUserByUsername(String username) throws UserNotFoundException;

    User changeGrxx(String username, String nickname, String birth, String gender) throws UpdateException;

    User changeBcnumber(String username, String bcnumber, String areas) throws UpdateException;

    void changePassword(Integer id,String oldPassword, String newPassword, String vfcode, String randcode) throws
            UpdateException,PasswordNotMatchException,ValidateCodeErrorException;

    void changeEmail(Integer id, String email, String vfcode, String randcode) throws
            ValidateCodeErrorException ,UpdateException;

    void changePhone(Integer id, String phone, String vfcode, String randcode)throws
            ValidateCodeErrorException ,UpdateException;


    void updateQuestion(Integer id,User user) throws UserNotFoundException,UpdateException;
}
