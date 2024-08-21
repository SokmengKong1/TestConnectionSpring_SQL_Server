package kh.edu.bbu.testconnectionspring_sql_server.MessageResponce;

import jakarta.websocket.OnClose;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponse {
    private String code;
    private String message;
    private String messageKh;
    private  Object data;
    public void setDataSuccess(Object data){
        this.setCode("200");
        this.setMessage("Success");
        this.setMessageKh("Get Success");
        this.setData(data);
    }
    public void setDataSuccesss(Object data){
        this.setCode("200");
        this.setMessage("Success");
        this.setMessageKh("Get Success");
        this.setData(data);
    }
}
