package rest;

import Utils.Delay;
import org.json.*;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RESTController {

    private static final int CONNECTION_TRIES = 3;
    private static final int WAITING_TIME_SEC = 30;

    public static JSONObject getJSON(URI link) {
        return new JSONObject(getString(link));
    }

    public static JSONArray getJSONArray(URI link) {
        return new JSONArray(getString(link));
    }

    private static String getString(URI link){
        for(int i = 0; i < CONNECTION_TRIES; i++) {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(link).build();
                HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body().toString();
            } catch (IOException | InterruptedException e) {
                System.out.println("EXCEPTION: couldn't open stream. Reason: " + e.getMessage());
                if (e.getMessage().contains("Server returned HTTP response code: 429"))
                    System.out.println("Too many requests.");
                System.out.println("Reconnect [" + (i + 1) + "/" + CONNECTION_TRIES + "] in" + WAITING_TIME_SEC + " seconds...");
                Delay.waitSeconds(WAITING_TIME_SEC);
            }
        }
        return null;
    }
}
