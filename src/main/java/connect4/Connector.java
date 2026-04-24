package connect4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import connect4.response.ListStrategiesResponse;
import connect4.response.Connect4Error;
import connect4.response.ErrorResponse;
import connect4.response.MoveResponse;
import connect4.response.NewGameResponse;
import connect4.response.OKResponse;
import connect4.response.StatusResponse;


public class Connector {
    private final String baseUrl;
    private final String user;
    private final HttpClient client;
    private final String params;
 
    public Connector(String baseUrl, String user) 
    {
        this.baseUrl = baseUrl;
        this.user = user;
        this.client = HttpClient.newHttpClient();
        this.params = "?user=" + user;
    }
    
    // start a new game
    public NewGameResponse newGame() 
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/newgame" + params))
            .GET()
            .build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() >= 300) {
                ErrorResponse err = ErrorResponse.fromJson(response.body());
                throw new Connect4Error(err);
            }
            return NewGameResponse.fromJson(response.body());
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public MoveResponse makeMove(int col) 
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/move" + params + "&column=" + col))
            .GET()
            .build();
        //System.out.println("Request: " + request);
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() >= 300) {
                ErrorResponse err = ErrorResponse.fromJson(response.body());
                throw new Connect4Error(err);
            }
            return MoveResponse.fromJson(response.body());
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public StatusResponse status()
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/status" + params))
            .GET()
            .build();
        //System.out.println("Request: " + request);
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() >= 300) {
                ErrorResponse err = ErrorResponse.fromJson(response.body());
                throw new Connect4Error(err);
            }
            return StatusResponse.fromJson(response.body());
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ListStrategiesResponse listStrategies()
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/liststrats" + params))
            .GET()
            .build();
        //System.out.println("Request: " + request);
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() >= 300) {
                ErrorResponse err = ErrorResponse.fromJson(response.body());
                throw new Connect4Error(err);
            }
            return ListStrategiesResponse.fromJson(response.body());
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public OKResponse setStrategy(String strategy)
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/setstrat" + params + "&strategy=" + strategy))
            .GET()
            .build();
        //System.out.println("Request: " + request);
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() >= 300) {
                ErrorResponse err = ErrorResponse.fromJson(response.body());
                throw new Connect4Error(err);
            }
            return OKResponse.fromJson(response.body());
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
}