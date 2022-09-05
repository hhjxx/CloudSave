package cloudsave.exception;

import cloudsave.result.Result;
import cloudsave.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    protected Result result;

    public BaseException(Result result) {
        super(result.getMessage());
        this.result = result;
    }

    public BaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.result = new Result().error(resultCodeEnum);
    }
}
