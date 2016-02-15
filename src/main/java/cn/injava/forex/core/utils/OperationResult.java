/**
 * Copyright (c) 2012
 */
package cn.injava.forex.core.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 用于Object到JSON序列化的对象结构体定义
 */
@JsonInclude(Include.NON_NULL)
public class OperationResult {

    /** 标识操作成功与否 */
    public enum OPERATION_RESULT_TYPE {
        success, warning, failure, confirm
    }
    
    public enum CodeMessage {
    	
    	S001("请求成功"),
    	
        E100("请求客户端IP不合法"),

        E101("校验未通过"),
        
        E111("起始城市不能为空"),
        
        E112("车源ID不能为空"),
        
        E113("用户ID不能为空"),
        
        E114("订单ID不能为空"),

        E115("订单Uid和Cid已存在"),

        E201("该订单不是当前流程处理"),
        
    	E102("系统错误");
    	
        private String message;
        
        private CodeMessage(String message) {
            this.message = message;
        }

        public CodeMessage format(Object... params) {
            this.message = String.format(this.message, params);
            return this;
        }

        public String getMessage() {
            return message;
        }
    }

    /** 返回success或failure操作标识 */
    private String type;
    /** 国际化处理的返回JSON消息正文 */
    private String message;
    /** 标识redirect路径 */
    private String redirect;
    /** 补充的数据 */
    private Object userdata;

    public static OperationResult buildSuccessResult(String message, Object userdata) {
        return new OperationResult(OPERATION_RESULT_TYPE.success, message, userdata);
    }

    public static OperationResult buildSuccessResult() {
        return new OperationResult(OPERATION_RESULT_TYPE.success, null);
    }

    public static OperationResult buildSuccessResult(String message) {
        return new OperationResult(OPERATION_RESULT_TYPE.success, message);
    }

    public static OperationResult buildWarningResult(String message) {
        return new OperationResult(OPERATION_RESULT_TYPE.warning, message, null);
    }

    public static OperationResult buildWarningResult(String message, Object userdata) {
        return new OperationResult(OPERATION_RESULT_TYPE.warning, message, userdata);
    }

    public static OperationResult buildFailureResult(String message) {
        return new OperationResult(OPERATION_RESULT_TYPE.failure, message);
    }

    public static OperationResult buildFailureResult(String message, Object userdata) {
        return new OperationResult(OPERATION_RESULT_TYPE.failure, message, userdata);
    }

    public static OperationResult buildConfirmResult(String message, Object userdata) {
        return new OperationResult(OPERATION_RESULT_TYPE.confirm, message, userdata);
    }

    public OperationResult(OPERATION_RESULT_TYPE type, String message) {
        this.type = type.name();
        this.message = message;
    }

    public OperationResult(OPERATION_RESULT_TYPE type, String message, Object userdata) {
        this.type = type.name();
        this.message = message;
        this.userdata = userdata;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getUserdata() {
        return userdata;
    }

    public void setUserdata(Object userdata) {
        this.userdata = userdata;
    }

    public OperationResult setRedirect(String redirect) {
        this.redirect = redirect;
        return this;
    }

    public String getRedirect() {
        return redirect;
    }
}
