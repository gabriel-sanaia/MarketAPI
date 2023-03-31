package com.example.marketapi.DTO;

public class ResponseBodyDTO {
    private String status;
    private String exceptionText;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExceptionText() {
        return exceptionText;
    }

    public void setExceptionText(String exceptionText) {
        this.exceptionText = exceptionText;
    }
}
