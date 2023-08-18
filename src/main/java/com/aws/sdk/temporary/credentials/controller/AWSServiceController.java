package com.aws.sdk.temporary.credentials.controller;

import com.aws.sdk.temporary.credentials.model.S3BucketsResponseModel;
import com.aws.sdk.temporary.credentials.serviceImp.S3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AWSServiceController {

    private S3ServiceImpl s3Service;

    @Autowired
    public AWSServiceController(S3ServiceImpl s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/s3")
    @ResponseBody
    public S3BucketsResponseModel getListBuckets() {
        return s3Service.getListBuckets();
    }
}
