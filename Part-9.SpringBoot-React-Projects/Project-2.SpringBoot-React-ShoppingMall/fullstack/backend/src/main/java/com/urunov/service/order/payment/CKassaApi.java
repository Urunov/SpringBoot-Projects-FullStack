package com.urunov.service.order.payment;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Service
public class CKassaApi {

    @Value("${ckassa.sslPath}")
    private String sslPath;

    @Value("${ckassa.sslPassword}")
    private String sslPassword;

    public String call(String method, String methodParams) throws Exception
    {
        StringBuilder res = new StringBuilder();
        String url = "https://demo-api.ckassa.ru/api-shop/" + method;
        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(readStore(), sslPassword.toCharArray())
                .build();
        CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        HttpPost httpMethod = new HttpPost(url);
        StringEntity params = new StringEntity(methodParams, StandardCharsets.UTF_8.name());
        httpMethod.setEntity(params);
        httpMethod.addHeader("Content-Type", "application/json");
        try (CloseableHttpResponse response = httpClient.execute(httpMethod))
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
            String line = "";
            while((line = rd.readLine()) != null)
                res.append(line);
        }
        return res.toString();
    }

    KeyStore readStore() throws Exception
    {
        try (InputStream keyStoreStream = new FileInputStream(new File(sslPath)))
        {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(keyStoreStream, sslPassword.toCharArray());
            return keyStore;
        }
    }
}
