package com.ohmygod.exception;

import lombok.Data;

@Data
public class ShopAgentFrameException extends BaseException {
    private Integer code;

    private String message;

    public ShopAgentFrameException() {
        super();
    }

    public ShopAgentFrameException(String message) {
        super(message);
    }

    public ShopAgentFrameException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ShopAgentFrameException(String message, Integer code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public ShopAgentFrameException(Throwable cause, Integer code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ShopAgentFrameException(String message, Throwable cause, Integer code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public ShopAgentFrameException(Integer code, String message, Throwable cause, Integer code1, String message1) {
        super(code, message, cause);
        this.code = code1;
        this.message = message1;
    }
}
