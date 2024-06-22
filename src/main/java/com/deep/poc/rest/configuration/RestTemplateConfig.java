package com.deep.poc.rest.configuration;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class RestTemplateConfig {

//    @Autowired
//    LoggingInterceptor loggingInterceptor;

    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setConnectionRequestTimeout(3000);
        requestFactory.setHttpClient(httpClient());
        return requestFactory;
    }

    @Bean
    public CloseableHttpClient httpClient() {
        return HttpClients.custom().setConnectionManager(poolingConnectionManager()).build();
    }

    @Bean
    public PoolingHttpClientConnectionManager poolingConnectionManager() {
        PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
        poolingConnectionManager.setMaxTotal(200);
        poolingConnectionManager.setDefaultMaxPerRoute(20);
        return poolingConnectionManager;
    }

    @Bean
    RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate(requestFactory());
//        restTemplate.setInterceptors(Collections.singletonList(loggingInterceptor));
        return restTemplate;
    }

}
