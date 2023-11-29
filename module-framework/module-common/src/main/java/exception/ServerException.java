package exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Date:2023/11/14 11:30
 * 服务器异常 Exception
 * @Author:poboking
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServerException extends RuntimeException{
    /**
     * 全局错误码
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;
    /**
     * 空构造方法，避免反序列化问题
     */
    public ServerException(){}
    public ServerException(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public ServerException setCode(Integer code){
        this.code = code;
        return this;
    }
    public ServerException setMessage(String message){
        this.message = message;
        return this;
    }
}
