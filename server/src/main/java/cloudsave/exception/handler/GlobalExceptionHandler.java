package cloudsave.exception.handler;

import cloudsave.exception.BaseException;
import cloudsave.result.Result;
import cloudsave.result.ResultCodeEnum;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, BaseException e){
        return e.getResult();
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
        return new Result().error(ResultCodeEnum.NULL_POINT_EXCEPTION);
    }

    @ExceptionHandler(value = HttpMessageConversionException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, HttpMessageConversionException e){
        return new Result().error(ResultCodeEnum.PARAM_ERROR);
    }

    @ExceptionHandler(value = FileSizeLimitExceededException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, FileSizeLimitExceededException e){
        return new Result().error(ResultCodeEnum.FILE_SIZE_TOO_LARGE);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, RuntimeException e){
        e.printStackTrace();
        return new Result().error().message(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        return new Result().error(ResultCodeEnum.UNKNOW_REASON);
    }
}