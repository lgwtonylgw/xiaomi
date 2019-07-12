package cn.tedu.xiaomi.service.impl;

import cn.tedu.xiaomi.entity.User;
import cn.tedu.xiaomi.mapper.UserMapper;
import cn.tedu.xiaomi.service.IUserService;
import cn.tedu.xiaomi.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceIMpl implements IUserService {
    @Autowired
   private  UserMapper userMapper;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void reg(User user) throws UsernameDuplicateException, InsertException {
        User result=userMapper.findByUsername(user.getUsername());
        if(result==null){
            Date now =new Date();
            user.setCreatedTime(now);
            user.setModifiedTime(now);
            user.setCreatedUser(user.getUsername());
            user.setModifiedUser(user.getUsername());
            String salt= UUID.randomUUID().toString().toUpperCase();
            String md5Password=getMd5Passowrd(user.getPassword(),salt);
            user.setSalt(salt);
            user.setPassword(md5Password);
            Integer rows=userMapper.insert(user);
            if(rows!=1){
                throw new InsertException("系统繁忙，请稍后再试");
            }
        }else{
            throw new UsernameDuplicateException("用户名已占用");
        }
    }

    @Override
    public void check(String emailCode,String checkCode) throws EmailCodeWrongException {
        System.out.println(checkCode);
        if(!checkCode.equals(emailCode)){
            throw new EmailCodeWrongException("验证码错误!");
        }
    }

    @Override
    public void SendEmail(String email, String checkCode) throws EmailNotSendException {
        try{
            System.out.println(email);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1323795603@qq.com");
            message.setTo(email);
            message.setSubject("主题：验证码");
            message.setText(checkCode);

            mailSender.send(message);
        }catch (Exception e){
            throw new EmailNotSendException("邮件发送失败");
        }
    }

    @Override
    public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        User result=userMapper.findByUsername(username);
        if(result==null){
            throw  new UserNotFoundException("用户名不存在！");
        }
        String salt=result.getSalt();
        System.out.println(password+" "+salt);
        String md5Password=getMd5Passowrd(password,salt);
        if(!result.getPassword().equals(md5Password)){
            throw  new PasswordNotMatchException("密码错误");
        }
        result.setPassword(null);
        result.setSalt(null);
        return  result;
    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
        User user=userMapper.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException("用户名不存在");
        }
        return user;
    }

    @Override
    public void changeAvatar(Integer id, String userimg) throws UserNotFoundException, UpdateException {
        User result=userMapper.findUserById(id);
        if(result==null){  //401
            throw new UserNotFoundException("修改头像错误，尝试访问的用户数据不存在！");
        }
        Integer rows=userMapper.updateUserimg(id,userimg);
        if(rows!=1){    //501
            throw new UpdateException("修改头像错误，更新数据时发生未知错误！");
        }
    }
    public User findUserByUsername(String username)throws UserNotFoundException{
        User u = getUserByUsername(username);
        return u;
    }

    @Override
    public User changeGrxx(String username, String nickname, String birth, String gender) throws UpdateException{
        Integer rows=userMapper.updateGrxx(username,nickname,birth,gender);
        if(rows!=1){
            throw new UpdateException("更新个人信息发生未知错误！");
        }
        User user=findUserByUsername(username);
        return user;
    }

    @Override
    public User changeBcnumber(String username, String bcnumber, String areas) throws  UpdateException{
        Integer rows=userMapper.updateBcnumber(username,bcnumber,areas);
        if(rows!=1){
            throw new UpdateException("更新银行卡号发生未知错误！");
        }
        User user=findUserByUsername(username);
        return user;
    }

    @Override
    public void changePassword(Integer id,String oldPassword, String newPassword, String vfcode, String randcode)
            throws UpdateException, PasswordNotMatchException, ValidateCodeErrorException {
        User user=getUserById(id);
        String salt=user.getSalt();
        String username=user.getUsername();
        String oldMd5Password=getMd5Passowrd(oldPassword,salt);
        if(!user.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("修改密码错误，原密码错误！");
        }
        if(!vfcode.toUpperCase().equals(randcode)){
            throw new ValidateCodeErrorException("验证码错误，请重新输入！");
        }
        String newMd5Password=getMd5Passowrd(newPassword,salt);
        Date now=new Date();
        Integer rows=userMapper.updatePassword(id,newMd5Password,now,username);
        if(rows!=1){
            throw new UpdateException("修改密码发生错误，更新数据时发生未知错误!");
        }
    }

    @Override
    public void changeEmail(Integer id, String email, String vfcode, String randcode) throws ValidateCodeErrorException, UpdateException {
        User user=getUserById(id);
        String username=user.getUsername();
        Date now=new Date();
        if(!vfcode.toUpperCase().equals(randcode)){
            throw new ValidateCodeErrorException("验证码错误!");
        }
        user.setEmail(email);
        user.setModifiedTime(now);
        user.setModifiedUser(username);
        Integer rows=userMapper.updateInfo(user);
        if(rows!=1){
            throw new UpdateException("修改邮箱出错，更新时发生未知错误！");
        }
    }

    @Override
    public void changePhone(Integer id, String phone, String vfcode, String randcode) throws
            ValidateCodeErrorException, UpdateException {
        User user=getUserById(id);
        String username=user.getUsername();
        Date now=new Date();
        if(!vfcode.toUpperCase().equals(randcode)){
            throw new ValidateCodeErrorException("验证码错误!");
        }
        user.setPhone(phone);
        user.setModifiedTime(now);
        user.setModifiedUser(username);
        Integer rows=userMapper.updateInfo(user);
        if(rows!=1){
            throw new UpdateException("修改手机号出错，更新时发生未知错误！");
        }
    }

    @Override
    public void updateQuestion(Integer id,User user) throws UserNotFoundException, UpdateException {
        User u=getUserById(id);
        String username=u.getUsername();
        Date now=new Date();
        user.setId(id);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        System.out.println(user);
        Integer rows=userMapper.updateQuestion(user);
        if(rows!=1){
            throw new UpdateException("修改密保问题出错，更新时发生未知错误");
        }
    }

    //--------------------------------------------------------------------
    //私有方法，受保护
    private User getUserById(Integer id) throws UserNotFoundException{
        User u=userMapper.findUserById(id);
        if(u==null){
            throw new UserNotFoundException("用户不存在!");
        }
        return u;
    }
    private User getUserByUsername(String username) throws UserNotFoundException{
        User user=userMapper.findUserByUsername(username);
        if(user==null){
            throw new UserNotFoundException("用户不存在");
        }
        return user;
    }
    private String getMd5Passowrd(String password, String salt){
        String str=salt+password+salt;
        for (int i = 0; i < 5; i++) {
            str= DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
        }
        return  str;
    }
}
