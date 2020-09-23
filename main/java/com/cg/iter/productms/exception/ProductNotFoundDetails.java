package com.cg.iter.productms.exception;

import java.io.Serializable;

public class ProductNotFoundDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }

    private String details;

    public void setDetails(String details){
      this.details=details;
    }

    public String getDetails(){
        return details;
    }

    private long timestamp;

    public long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(long timestamp){
        this.timestamp=timestamp;
    }

    public ProductNotFoundDetails(String msg,String details,long time){
        this.message=msg;
        this.details=details;
        this.timestamp=time;
    }


    public ProductNotFoundDetails(){

    }
}
