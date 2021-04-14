package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class UploadFile {

    private String fileName;
    @Lob
    private byte[] data;
    private String type;


    public UploadFile(String fileName, byte[] data, String type) {
        this.fileName = fileName;
        this.data = data;
        this.type = type;
    }

    protected UploadFile(){}


    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
