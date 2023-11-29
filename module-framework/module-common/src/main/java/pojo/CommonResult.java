package pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import exception.ErrorCode;
import exception.ServerException;
import exception.ServiceException;
import exception.enums.GlobalErrorCodeConstants;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;

/**
 * Date:2023/11/20 9:47
 *
 * @Author:poboking
 */
@Data
public class CommonResult<T> implements Serializable {
    /**
     * 错误码
     * @see ErrorCode#getCode()
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误提示
     * @see ErrorCode#getMsg()
     */
    private String msg;

    /**
    * 将一个类型的CommonResult转换为另一类型的CommonResult。
    * @param result 传入的 result 对象
    * @param <T> 返回的泛型
    * @return 新的 CommonResult 对象
    */
    public static <T> CommonResult<T> error (CommonResult<?> result){
        return error(result.getCode(),result.getMsg());
    }

    /**
     * 创建一个错误返回
     * @param code 错误码
     * @param message 错误提示
     * @return 新的CommonResult 对象
     * @param <T> 返回的泛型
     */
    public static <T> CommonResult<T> error(Integer code,String message) {
        //Assert 代码断言
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code),
                "The code must be fault!");
        CommonResult<T> result = new CommonResult<>();
        result.code =  code;
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode){
        return error(errorCode.getCode(),errorCode.getMsg());
    }

    /**
     * 创建一个正确返回
     * @param data 传入的 result 对象
     * @param <T> 返回的泛型
     * @return 新的 CommonResult 对象
     */
    public static <T> CommonResult<T> success(T data){
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        result.data = data;
        result.msg = GlobalErrorCodeConstants.SUCCESS.getMsg();
        return result;
    }

    public static boolean isSuccess(Integer code){
        return Objects.equals(code,GlobalErrorCodeConstants.SUCCESS.getCode());
    }

    /**
     * CommonResult实例,判断自己正确与否的方法
     * @return boolean of isSuccess
     */
    @JsonIgnore //避免jackson序列化
    public boolean isSuccess(){
        return isSuccess(code);
    }

    @JsonIgnore //避免jackson序列化
    public boolean isError(){
        return isSuccess();
    }

    /**
     * 判断是否有异常。如果有，则抛出 {@link ServiceException} 异常
     */
    public void checkError()throws ServiceException{
        //判断是否正确
        if (isSuccess()){
            return;
        }
        //服务端错误
        if (GlobalErrorCodeConstants.isServerErrorCode(code)){
            throw new ServerException(code,msg);
        }
        //业务错误
        throw  new ServiceException(code,msg);
    }

    /**
     * 判断是否异常,若无则返回数据
     */
    @JsonIgnore //避免jackson序列化
    public T getCheckError(){
        checkError();
        return data;
    }

    /**
     * 将对应的异常转换为统一的CommonResult返回类
     */
    public static <T> CommonResult<T> error(ServiceException serviceException){
        return error(serviceException.getCode(),serviceException.getMessage());
    }

    public static <T> CommonResult<T> error(ServerException serverException){
        return error(serverException.getCode(),serverException.getMessage());
    }

}
