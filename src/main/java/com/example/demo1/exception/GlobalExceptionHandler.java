package com.example.demo1.exception;

import com.example.demo1.controller.BookController;
import com.example.demo1.controller.ExceptionController;
import com.example.demo1.domain.ErrorResponse;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(assignableTypes = {ExceptionController.class, BookController.class})
@ResponseBody
public class GlobalExceptionHandler {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误！"));
    ErrorResponse resourseNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("Sorry,the resource not fount"));

    //拦截指定异常，返回值是自定义的Error Response
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resourseNotFoundResponse);
        }/*else if (e instanceof MethodArgumentNotValidException){
            HashMap<String,String> map = new HashMap<>();
            List<ObjectError> errors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            for (ObjectError error : errors) {
                String field = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                map.put(field,message);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }*/
        return null;
    }
    //拦截特定异常，返回值是Map
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidatrionException(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error->{
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        }));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
