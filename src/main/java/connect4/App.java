package connect4;

import connect4.response.ListStrategiesResponse;
import connect4.response.MoveResponse;
import connect4.response.NewGameResponse;

public class App {
    public static void main(String[] args) throws Exception
    {
        //String baseUrl = "http://euclid.knox.edu:8083/connect4";
        String baseUrl = "http://localhost:8080/connect4";
        String user = "spacco";
        
        Connector c = new Connector(baseUrl, user);
        NewGameResponse response = c.newGame();

        System.out.println(response.status + ", " + response.message);

        ListStrategiesResponse listStrategies = c.listStrategies();
        System.out.println(listStrategies.getStrategies()[0].name);

        MoveResponse moveResponse = c.makeMove(99);
        System.out.println(moveResponse.status);
    }
}
