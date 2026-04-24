package connect4.response;

import com.google.gson.*;

public class StatusResponse
{
    public String status;
    public boolean gameOver;
    public String winner;
    public int[][] board;

    public static StatusResponse fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, StatusResponse.class);
    }
    public String toString()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
    
    
}
