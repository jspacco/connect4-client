package connect4.response;

import com.google.gson.*;

import connect4.Strategy;

public class ListStrategiesResponse {
    private String status;
    private Strategy[] strategies;

    public String getStatus() { return status; }
    public Strategy[] getStrategies() { return strategies; }

    public static ListStrategiesResponse fromJson(String json)
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, ListStrategiesResponse.class);
    }

    public String toString()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
