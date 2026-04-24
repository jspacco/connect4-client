package connect4.response;

import com.google.gson.*;

public class ErrorResponse {
    public int httpCode;
    public String status;
    public String message;

    public static ErrorResponse fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, ErrorResponse.class);
    }

    public String toString()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
