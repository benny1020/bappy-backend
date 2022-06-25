package spring.bappy.controllers.response;


import lombok.Data;

@Data
public class Message {

    private StatusEnum status;
    private String message;
    private Object data;

    private int token;

    public Message() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
        this.token = 1;
    }
}
