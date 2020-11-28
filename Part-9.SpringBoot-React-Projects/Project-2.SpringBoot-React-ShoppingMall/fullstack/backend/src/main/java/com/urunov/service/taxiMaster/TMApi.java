package com.urunov.service.taxiMaster;

import com.urunov.model.taxi.TaxiProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.*;
import java.net.*;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Service
public class TMApi {

    @Value("${tm.protocol")
    private String protocol;

    @Value("${tm.apiVersion}")
    private String apiVersion;

    private final Logger LOG = LoggerFactory.getLogger(TaxiOrderProcess.class);

    public String call(String method, String params, String way, String contentType, TaxiProperties taxiProperties)
    {
        try {

            URI uri = null;
            String signature = "";
            try
            {
                if(contentType.equals("application/json")) {
                    uri = new URI(protocol, taxiProperties.getHost() + ":" + taxiProperties.getPort(), "/common_api/" + apiVersion + "/" + method, null, null);
                    StringBuffer b = new StringBuffer();

                    for (char c : params.toCharArray()) {
                        if (c >= 128)
                            b.append("\\u").append(String.format("%04X", (int) c));
                        else
                            b.append(c);
                    }
                    params = b.toString();
                }
                else
                    {
                        URL url = new URL(protocol + "://" +
                            taxiProperties.getHost() + ":" + taxiProperties.getPort() + "/common_api"+
                            apiVersion + "/" + method + "?" + params);
                        uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(),
                                url.getPort(), url.getPath(), url.getQuery(), url.getRef());
                        String p[] = uri.toASCIIString().split("\\?");
                        if(p.length > 1)
                            params = p[1];
                        else
                            params = "";
                    }
                    signature = MD5(params + taxiProperties.getSecretKey());
            }
            catch(URISyntaxException ex){
                ex.printStackTrace();
                return null;
            }

        if(way.isEmpty() || way.equals("GET"))
                way = "GET";
            SSLUtilities.trustAllHostnames();
            SSLUtilities.trustAllHttpsCertificates();
            URL url;

            if(!way.equals("POST"))
                url = new URL(uri.toASCIIString());
            else
                url = new URL(uri.toString().split("\\?")[0]);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        if(way.equals("GET")){
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Signature", signature);
        }
        else
            {
                conn.setDoOutput(true);
                conn.setInstanceFollowRedirects(false);
                conn.setRequestMethod(way);
                conn.setRequestProperty("Content-Type", contentType);
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Signature", signature);
                byte[] postData = params.getBytes(StandardCharsets.UTF_8);
                int postDataLength = postData.length;
                conn.setRequestProperty("charset", "utf-8");
                conn.setRequestProperty("Connect-Length", Integer.toString(postDataLength));
                conn.setUseCaches(false);

                try (BufferedOutputStream wr = new BufferedOutputStream(conn.getOutputStream()))
                {
                    wr.write(postData);
                }
            }
            if(conn.getResponseCode() != 200)
                throw new RuntimeException("Failed: Http error code: " + conn.getResponseCode());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((conn.getInputStream()), StandardCharsets.UTF_8));
            String response = "";
            String output;

            while ((output = br.readLine()) != null){
                response += output + "\n";
            }

            conn.disconnect();
            return response;
        }
        catch (MalformedInputException e)
        {
            LOG.error(
                    "Error calling TMServer Common API" + e.getLocalizedMessage() + "\n\t\t" + e.getStackTrace()[0]);
        }
        catch (IOException ex){
            LOG.error(
                    "Error calling RMServer Common API" + ex.getLocalizedMessage() + "\n\t\t" + ex.getStackTrace()[0]);

        }
        return null;
        }



    private String MD5(String str){

        MessageDigest md5;
        StringBuffer hexString = new StringBuffer();
        try
        {
            md5 = MessageDigest.getInstance("md5");
            md5.reset();
            md5.update(str.getBytes());
            byte messageDigest[] = md5.digest();
            for(int i = 0; i < messageDigest.length; i++)
            {
                hexString.append(Integer.toHexString((0xFF & messageDigest[i]) | 0x100).substring(1, 3).toUpperCase());
            }
        }
        catch(NoSuchAlgorithmException e)
        {
            return e.toString();
        }
        return hexString.toString();
        }
    }
