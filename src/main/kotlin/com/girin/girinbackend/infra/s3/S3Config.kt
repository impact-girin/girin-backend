package com.girin.girinbackend.infra.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3Config(
    @Value("\${spring.cloud.aws.credentials.access-key}")
    val accessKey: String,

    @Value("\${spring.cloud.aws.credentials.secret-key}")
    val secretKey: String,
) {
    @Bean
    fun amazonS3Client(): AmazonS3Client {
        val awsCredentials = BasicAWSCredentials(accessKey, secretKey);

        return AmazonS3ClientBuilder.standard()
            .withRegion(Regions.AP_NORTHEAST_2).enablePathStyleAccess()
            .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
            .build() as AmazonS3Client
    }
}
