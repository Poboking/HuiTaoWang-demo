package io.studio.auth.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局校验异常捕获器
 * Date:2023/12/8 13:51
 *
 * @Author:poboking
 */
//@ControllerAdvice
public class BadRequestException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<List<String>> processUnmergeException(final
                                                                MethodArgumentNotValidException ex) {
        List<String> list = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}

class DefaultMessageSourceResolvable {
    public static String getDefaultMessage(ObjectError error) {
        return error.getDefaultMessage();
    }
}
