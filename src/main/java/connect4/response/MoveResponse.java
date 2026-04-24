package connect4.response;

import com.google.gson.*;

public class MoveResponse 
{
    public String status;
    public Integer playerMove;
    public Integer serverMove;
    public boolean gameOver;
    public String winner;
    public int[][] board;

    public static MoveResponse fromJson(String json)
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, MoveResponse.class);
    }

    public String toString()
    {
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return status + "\n" + 
            "Player Move: " + playerMove + "\n" +
            "Server Move: " + serverMove + "\n" +
            "Game Over: " + gameOver + "\n" +
            "Winner: " + winner + "\n" +
            "Board:\n" + Util.boardToString(board);
    }
}
