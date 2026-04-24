package connect4.response;

import com.google.gson.*;

public class OKResponse {
    public String status;
    public String message;

    public static OKResponse fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, OKResponse.class);
    }

}
