package com.aws.sdk.temporary.credentials.model;

import lombok.Data;

import java.util.List;

@Data
public class S3BucketsResponseModel {

    private List<S3BucketInfoModel> S3Buckets;

    public S3BucketsResponseModel() {
    }

    public S3BucketsResponseModel(List<S3BucketInfoModel> s3Buckets) {
        S3Buckets = s3Buckets;
    }
}
