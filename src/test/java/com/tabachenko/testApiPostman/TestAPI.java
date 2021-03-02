package com.tabachenko.testApiPostman;
import io.restassured.RestAssured;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class TestAPI {

    @Test
    public void testingTest() throws IOException {


        String url = "https://reqres.in/api/users?page=2";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(2500);
            connection.setReadTimeout(2500);
            connection.connect();

            StringBuilder as = new StringBuilder();
            if (HttpURLConnection.HTTP_OK==connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line=in.readLine())!=null){
                    as.append(line);
                    as.append("\n");
                }
                System.out.println(as.toString());
            }else {
                System.out.println("fall"+connection.getResponseCode()+", "+ connection.getResponseMessage());
            }

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
