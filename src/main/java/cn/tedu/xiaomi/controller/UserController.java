package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.entity.User;
import cn.tedu.xiaomi.service.IUserService;
import cn.tedu.xiaomi.service.ex.*;
import cn.tedu.xiaomi.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created on 2019/6/2 21:31
 *
 * @author Tony
 * @projectName xiaomi
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    private String checkCode;
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")
    public ResponseResult<Void> reg(User user){
        userService.reg(user);
        return  new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("email")
    public ResponseResult<Void> sendCode(@RequestParam("emailAddress") String email){
        System.out.println(email);
        checkCode=String.valueOf(new Random().nextInt(99999));
        userService.SendEmail(email,checkCode);
        return new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("check")
    public ResponseResult<Void> checkCode(@RequestParam("emailCheck") String emailCode){
        System.out.println(emailCode);
        userService.check(emailCode,checkCode);
        return new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("login")
    public ResponseResult<User> login(String username, String password, HttpSession session){
        User result=userService.login(username,password);
        session.setAttribute("username",username);
        session.setAttribute("id",result.getId());
        return new ResponseResult<User>(SUCCESS,result);
    }
    @RequestMapping("info")
    public ResponseResult<User> getInfo(HttpSession session){
        String username=getUsernameFromSession(session);
        User user= userService.findByUsername(username);
        return new ResponseResult<>(SUCCESS,user);
    }

    @RequestMapping("grxx")
    public ResponseResult<User> grxx(HttpSession session){
        System.out.println("开始加载grxx");
        String username=getUsernameFromSession(session);
        User user=userService.findUserByUsername(username);
        return new ResponseResult<>(SUCCESS,user);
    }
    @RequestMapping("changegrxx")
    public ResponseResult<User> changegrxx(String nickname,String birth,String gender,HttpSession session){
        String username=getUsernameFromSession(session);
        User user=userService.changeGrxx(username,nickname,birth,gender);
        return new ResponseResult<>(SUCCESS,user);
    }
    @RequestMapping("bcnumber")
    public ResponseResult<User> changeBcnumber(String bcnumber,String areas,HttpSession session) {
        String username = getUsernameFromSession(session);
        User user = userService.changeBcnumber(username, bcnumber, areas);
        return new ResponseResult<>(SUCCESS, user);
    }
    @RequestMapping("changepassword")
    public ResponseResult<Void> changePassword(String oldPassword,String newPassword,String vfcode,HttpSession session){
        Integer id=getUidFromSession(session);
        String randcode=((String)session.getAttribute("randCheckCode")).toUpperCase();
        System.out.println(randcode);
        userService.changePassword(id,oldPassword,newPassword,vfcode,randcode);
        return  new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("changeemail")
    public ResponseResult<Void> changeEmail(String email,String vfcode,HttpSession session){
        Integer id=getUidFromSession(session);
        String randcode=((String)session.getAttribute("randCheckCode")).toUpperCase();
        userService.changeEmail(id,email,vfcode,randcode);
        return new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("changephone")
    public ResponseResult<Void> changePhone(String phone,String vfcode,HttpSession session){
        Integer id=getUidFromSession(session);
        String randcode=((String)session.getAttribute("randCheckCode")).toUpperCase();
        userService.changePhone(id,phone,vfcode,randcode);
        return new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("changequestion")
    public ResponseResult<Void> changeQuestion(User user,HttpSession session){
        Integer id=getUidFromSession(session);
        userService.updateQuestion(id,user);
        return new ResponseResult<>(SUCCESS);
    }



    //修
    //
    //
    //
    //
    //
    //
    // 改用户头像
    /**
     * 保存用户上传头像文件夹
     */
    public static final String UPLOAD_DIR = "upload";
    /**
     * 上传头像的最大大小
     */
    public static final long UPLOAD_AVATAR_MAX_SIZE = 1*1024*1024;
    /**
     * 上传头像的文件类型
     */
    public static final List<String> UPLOAD_AVATAR_TYPES = new ArrayList<>();

    static {
        UPLOAD_AVATAR_TYPES.add("image/jpeg");
        UPLOAD_AVATAR_TYPES.add("image/png");
    }

    @PostMapping("file")
    public ResponseResult<String> changeAvatar(HttpServletRequest request,
                                               @RequestParam("file") MultipartFile avatar, HttpSession session) {
        // 通过request对象获取项目部署到的文件夹中的某子级文件夹
        String parentPath = request.getServletContext().getRealPath(UPLOAD_DIR);
        //检查是否选择了有效文件提交的请求
        if(avatar.isEmpty()) {
            //抛出异常:FileEmptyException  600
            throw new FileEmptyException("上传头像失败！未选择头像文件，或选择的文件为空！");
        }
        //检查文件大小是否超标
        long size = avatar.getSize();
        if(size>UPLOAD_AVATAR_MAX_SIZE) {
            //抛出异常：FileSizeException  604
            throw new FileSizeException("上传头像失败！不允许使用超过" + UPLOAD_AVATAR_MAX_SIZE / 1024 + "KB的文件！");
        }
        //检查文件类型是否在允许的范围之内
        String contentType = avatar.getContentType();
        if(!UPLOAD_AVATAR_TYPES.contains(contentType)) {
            //抛出异常：FileTypeException 601
            throw new FileTypeException("上传头像失败！不支持所提交的文件类型！允许的文件类型有：" + UPLOAD_AVATAR_TYPES);
        }
        // 确定保存到哪个文件夹
        File parent = new File(parentPath);
        // 确保文件夹是存在的
        if (!parent.exists()) {//如果文件夹不存在
            //创建文件夹
            parent.mkdirs();
        }

        // 确定保存的文件名     获取上传的文件的原始名称
        String originalFilename = avatar.getOriginalFilename();
        // 确定上传的文件的扩展名
        String suffix = "";//例如：.png  .jpg  .gif
        //根据最后一个"."来截取来获得扩展名
        int beginIndex = originalFilename.lastIndexOf(".");
        //如果文件存在扩展名，不存在就直接是" "
        if (beginIndex != -1) {
            //根据"."来获取扩展名
            suffix = originalFilename.substring(beginIndex);
        }
        // 确定上传的文件最终保存时使用的文件名，这里用到随机盐
        String child = UUID.randomUUID().toString() + suffix;

        // 确定保存到哪个文件
        File dest = new File(parent, child);
        // 保存头像文件
        try {
            avatar.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            //抛出异常：FileStateException 602
            throw new FileStateException("上传头像失败！所选择的文件已经不可用！");
        } catch (IOException e) {
            e.printStackTrace();
            //抛出异常：FileIoException 603
            throw new FileIOException("上传头像失败！读写数据时出现错误！");
        }

        // 执行修改头像
        Integer id = getUidFromSession(session);//获取uid
        //头像路径
        String avatarPath = "/" + UPLOAD_DIR + "/" + child;

        userService.changeAvatar(id, avatarPath);

        //返回
        ResponseResult<String> rr = new ResponseResult<>();
        rr.setState(SUCCESS);
        rr.setData(avatarPath);
        //这里不能直接用构造方法，因为头像路径和message都是String类型，
        //直接用构造方法会被封装到message里面去，所以要分开，不能直接返回一个对象
        return rr;
    }
}
