package com.example.springbootdemo.util.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {
        private String code;
        private String msg;
        private T data;

        public static <T> ResponseResult<T> build(String code, String msg, T data) {
            return new ResponseResult<>(code, msg, data);
        }

        public static <T> ResponseResult<T> build(String code,String msg){
            return new ResponseResult<>(code,msg);
        }

        public static <T> ResponseResult<T> success(ResponseEnum resultStatusEnum, T data) {
            return new ResponseResult<>(resultStatusEnum, data);
        }

        public static <T> ResponseResult<T> error(ResponseEnum resultStatusEnum) {
            return new ResponseResult<>(resultStatusEnum);
        }

        public static <T> ResponseResult<T> buildClient(T data) {
            return new ResponseResult<>(data);
        }




        /**
         * 有错误的情况下需要传递错误码 + 错误提示
         *
         * @param code
         * @param msg
         */
        private ResponseResult(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        private ResponseResult(ResponseEnum resultStatusEnum, String msg) {
            this.code = resultStatusEnum.getCode();
            this.msg = msg;
        }

        private ResponseResult(ResponseEnum resultStatusEnum) {
            this.code = resultStatusEnum.getCode();
            this.msg = resultStatusEnum.getMsg();
        }

        /**
         * 客户端分页，只需要数据 data
         *
         * @param data
         */
        private ResponseResult(T data) {
            this.code = ResponseEnum.SUCCESS.getCode();
            this.msg = ResponseEnum.SUCCESS.getMsg();
            this.data = data;
        }

        private ResponseResult(String code, String msg, T data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        private ResponseResult(ResponseEnum resultStatusEnum, T data) {
            this.code = resultStatusEnum.getCode();
            this.msg = resultStatusEnum.getMsg();
            this.data = data;
        }

        private ResponseResult() {}


}
