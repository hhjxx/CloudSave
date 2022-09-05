package cloudsave.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(true,20000,"success"),
    UNKNOW_REASON(false,21001,"Unknown error!"),
    NULL_POINT_EXCEPTION(false,21002,"Null Point Exception!"),
    PARAM_ERROR(false,21003,"Param not correct!"),
    FILE_SIZE_TOO_LARGE(false,21004,"File too large!");


    private Boolean status;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
