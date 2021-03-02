package com.tabachenko.testApiPostman;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.InvalidObjectException;

import static io.restassured.RestAssured.*;

public class Test2 {

    final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void test2() throws InvalidObjectException {
        System.err.close();
        System.setErr(System.out);
        when().get("https://reqres.in/api/users?page=2").then().statusCode(200);
        Response response = get("https://reqres.in/api/users?page=2");
        String infoJson = response.getBody().asString();
        Page page = GSON.fromJson(infoJson, Page.class);
        for (Page.Data data : page.getData()) {
            System.out.println(data.getAvatar());
        }


    }

    //@Test
    public void postTest() {
        given().contentType("application/json").body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").when().post("https://reqres.in/api/users").then().statusCode(201);

        when().get("https://reqres.in/api/users").then().statusCode(200);

        Response response = get("https://reqres.in/api/users");
        System.out.println(response.getBody().asString());

    }
}
