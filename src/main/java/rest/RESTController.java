package rest;

import Utils.Delay;
import constants.Monobank;
import constants.SensitiveData;
import org.json.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RESTController {

    private static final int CONNECTION_TRIES = 3;
    private static final int WAITING_TIME_SEC = 30;

    private static String getString(HttpRequest request){
        for(int i = 0; i < CONNECTION_TRIES; i++) {
            try {

                HttpClient client = HttpClient.newHttpClient();
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

    public static JSONObject getClientInfo(String xToken) throws IOException, InterruptedException, URISyntaxException {

        URI uri = new URI(Monobank.API_ENDPOINT+Monobank.CLIENT_INFO_ENDPOINT);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("X-Token", xToken)
                .build();

        String jsonString = getString(request);

        return new JSONObject(jsonString);
    }
}
