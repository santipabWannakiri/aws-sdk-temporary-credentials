package com.aws.sdk.temporary.credentials.serviceImp;

import com.aws.sdk.temporary.credentials.configuration.ConnectionFactory;
import com.aws.sdk.temporary.credentials.exception.type.S3ConnectionException;
import com.aws.sdk.temporary.credentials.model.S3BucketInfoModel;
import com.aws.sdk.temporary.credentials.model.S3BucketsResponseModel;
import com.aws.sdk.temporary.credentials.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class S3ServiceImpl implements S3Service {

    private ConnectionFactory connectionFactory;

    @Autowired
    public S3ServiceImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public S3BucketsResponseModel getListBuckets() {
        try (S3Client s3Client = connectionFactory.getInstance()) {
            ListBucketsResponse listBucketsResponse = s3Client.listBuckets();
            S3BucketsResponseModel response = new S3BucketsResponseModel();
            List<S3BucketInfoModel> listBucketInfo = new ArrayList<>();
            for (Bucket bucket : listBucketsResponse.buckets()) {
                S3BucketInfoModel bucketInfo = new S3BucketInfoModel(bucket.name(), bucket.creationDate().toString());
                listBucketInfo.add(bucketInfo);
            }
            response.setS3Buckets(listBucketInfo);
            connectionFactory.close();
            return response;
        } catch (Exception e) {
           throw new S3ConnectionException(e.getMessage());
        }

    }
}
