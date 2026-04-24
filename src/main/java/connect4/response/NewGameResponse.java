package connect4.response;

import com.google.gson.*;

public class NewGameResponse 
{
    public String status;
    public String message;
    public String playerSymbol;
    public String serverSymbol;
    public int[][] board;
    

    public static NewGameResponse fromJson(String json) 
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, NewGameResponse.class);
    }
    
    public String toString()
    {
        return status + "\n" +
            "Message: " + message + "\n" +
            "Board:\n" + Util.boardToString(board);
    }


}
