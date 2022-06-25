package spring.bappy.controllers.response;

public enum StatusEnum {

    OK(200, "OK"),

    REVOKED_ID_TOKEN(10,"REVOKED_ID_TOKEN"),

    INVALID_ID_TOKEN(20, "INVALID_ID_TOKEN"),

    BAD_REQUEST(400, "BAD_REQUEST"),

    NOT_FOUND(404,"NOT_FOUND"),

    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR");

    int statusCode;

    String code;

    StatusEnum(int statusCode, String code) {
        this.statusCode = statusCode;
        this.code = code;
    }
}
