package kh.edu.bbu.testconnectionspring_sql_server.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppExceptions extends Exception{
    private String code;
    private String message;
    private String messagekh;

    public AppExceptions() {
        super();
    }

    public AppExceptions( String code,String message,  String messagekh) {
        super(message);
        this.code = code;
        this.message = message;
        this.messagekh = messagekh;
    }
}
