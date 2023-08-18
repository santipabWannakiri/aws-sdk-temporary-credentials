package com.aws.sdk.temporary.credentials.model;


import lombok.Data;

@Data
public class S3BucketInfoModel {

    private String name;
    private String  creationDate;

    public S3BucketInfoModel() {
    }

    public S3BucketInfoModel(String name, String  creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }


}
