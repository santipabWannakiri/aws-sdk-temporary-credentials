package com.aws.sdk.temporary.credentials.service;

import com.aws.sdk.temporary.credentials.model.S3BucketsResponseModel;

public interface S3Service {
    public S3BucketsResponseModel getListBuckets();
}
