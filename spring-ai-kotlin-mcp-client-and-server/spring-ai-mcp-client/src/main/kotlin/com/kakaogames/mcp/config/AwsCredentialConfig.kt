package com.kakaogames.mcp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider

@Configuration
class AwsCredentialConfig {

    /**
     * saml 로그인을 통해 인증하기 위해 필요
     */
    @Bean
    fun awsCredentialsProvider(): AwsCredentialsProvider {
        return ProfileCredentialsProvider.create("saml");
    }
}