package com.aws.sdk.temporary.credentials.configuration;

import com.aws.sdk.temporary.credentials.exception.type.AWSParameterNullException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Component
public class ConnectionFactory {
    @Value("${aws.profile}")
    private String awsProfileName;
    @Value("${aws.region}")
    private String awsRegion;
    private S3Client s3Client;

    private void createInstance() {
        if (awsProfileName == null) {
            throw new AWSParameterNullException("awsProfileName");
        }
        if (awsRegion == null) {
            throw new AWSParameterNullException("awsRegion");
        }
        s3Client = S3Client.builder().region(Region.of(awsRegion)).credentialsProvider(ProfileCredentialsProvider.create(awsProfileName))
                .httpClientBuilder(ApacheHttpClient.builder()).build();
    }
    //Singleton instance of S3Client
    public synchronized S3Client getInstance() {
        if (s3Client == null) {
            System.out.println("Open connection to S3...");
            createInstance();
        }
        return s3Client;
    }
    public synchronized void close() {
        if (s3Client != null) {
            System.out.println("Closing the connection to S3...");
            s3Client.close();
            s3Client = null;
        }
    }

}
