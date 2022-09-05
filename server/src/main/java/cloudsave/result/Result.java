package cloudsave.result;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Result<T> {
    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public Result() {
        this.setCode(ResultCodeEnum.SUCCESS.getCode());
        this.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        this.setMessage(ResultCodeEnum.SUCCESS.getMessage());
    }

    public Result<T> ok(){
        this.setCode(ResultCodeEnum.SUCCESS.getCode());
        this.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        this.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return this;
    }

    public Result<T> error(){
        this.setCode(ResultCodeEnum.UNKNOW_REASON.getCode());
        this.setSuccess(ResultCodeEnum.UNKNOW_REASON.getStatus());
        this.setMessage(ResultCodeEnum.UNKNOW_REASON.getMessage());
        return this;
    }

    public Result<T> ok(ResultCodeEnum codeEnum){
        this.setCode(codeEnum.getCode());
        this.setSuccess(codeEnum.getStatus());
        this.setMessage(codeEnum.getMessage());
        return this;
    }

    public Result<T> error(ResultCodeEnum codeEnum){
        this.setCode(codeEnum.getCode());
        this.setSuccess(codeEnum.getStatus());
        this.setMessage(codeEnum.getMessage());
        return this;
    }

    public Result<T> data(T data){
        this.setData(data);
        return this;
    }

    public Result<T> message(String message){
        this.setMessage(message);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result<T> success(Boolean success){
        this.setSuccess(success);
        return this;
    }

}
