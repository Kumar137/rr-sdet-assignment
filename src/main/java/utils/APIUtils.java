package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIUtils {

    public Response getApiRequest(Map query_params){
        RestAssured.baseURI=APIConfig.BASE_URI;
        RequestSpecification request=RestAssured.given();
        request.queryParams(query_params);
        return request.get();
    }
}
