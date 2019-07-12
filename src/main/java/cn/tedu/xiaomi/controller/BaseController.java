package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.service.ex.*;
import cn.tedu.xiaomi.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * Created on 2019/6/2 21:19
 *
 * @author Tony
 * @projectName xiaomi
 */
public abstract class BaseController {
    protected static final int SUCCESS=200;
    protected final Integer getUidFromSession(HttpSession ssession){
        return Integer.valueOf(ssession.getAttribute("id").toString());
    }
    protected final String getUsernameFromSession(HttpSession ssession){
        return (String)ssession.getAttribute("username");
    }
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public ResponseResult<Void> handleException(Exception e){
        ResponseResult<Void> rr=new ResponseResult<>();
        rr.setMessage(e.getMessage());
        if(e instanceof UsernameDuplicateException){
            rr.setState(400);
        }else if(e instanceof UserNotFoundException){
            rr.setState(401);
        }else if(e instanceof PasswordNotMatchException){
            rr.setState(402);
        }else if(e instanceof AddressNotFoundException){
            rr.setState(403);
        }else if(e instanceof AccessDeniedException){
            rr.setState(404);
        }else if(e instanceof CartNotFoundException){
            rr.setState(405);
        }else if(e instanceof ValidateCodeErrorException){
            rr.setState(406);
        }else if(e instanceof EmailNotSendException){
            rr.setState(407);
        }else if(e instanceof EmailCodeWrongException){
            rr.setState(408);
        }else if(e instanceof AddressLimitException){
            rr.setState(409);
        }else if(e instanceof InsertException){
            rr.setState(500);
        }else if(e instanceof UpdateException){
            rr.setState(501);
        }else if(e instanceof DeleteException){
            rr.setState(502);
        }else if(e instanceof FileEmptyException){
            rr.setState(600);
        }else if(e instanceof FileTypeException){
            rr.setState(601);
        }else if(e instanceof FileStateException){
            rr.setState(602);
        }else if(e instanceof FileIOException){
            rr.setState(603);
        }else if(e instanceof FileSizeException){
            rr.setState(604);
        }
        return rr;
    }
}
