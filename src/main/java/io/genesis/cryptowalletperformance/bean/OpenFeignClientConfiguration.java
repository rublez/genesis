package io.genesis.cryptowalletperformance.bean;

import org.springframework.context.annotation.Bean;

import feign.okhttp.OkHttpClient;

public class OpenFeignClientConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
