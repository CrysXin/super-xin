package com.course.business.controller;

import com.course.server.dto.ResponseDto;
import com.course.server.exception.ValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZHX on 2020/9/27.
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(value = ValidatorException.class)
   public ResponseDto validatorExceptionHandler(ValidatorException e){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setSuccess(false);
        LOG.warn(e.getMessage());
        responseDto.setMessage("请求参数异常！");
        return responseDto;
   }
}
