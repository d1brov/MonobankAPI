package rest;

import Utils.Delay;
import org.json.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RESTController {

    private static final int CONNECTION_TRIES = 3;
    private static final int WAITING_TIME_SEC = 30;

    private static String getJsonString(URL link){

        for(int i = 0; i < CONNECTION_TRIES; i++) {
            try {

                InputStream inputStream = link.openStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader re = new BufferedReader(inputStreamReader);
                String jsonString = Read(re);
                inputStream.close();
                return jsonString;

            } catch (IOException e) {

                System.out.println("EXCEPTION: couldn't open stream. Reason: " + e.getMessage());

                if (e.getMessage().contains("Server returned HTTP response code: 429"))
                    System.out.println("Too many requests.");

                System.out.println("Reconnect ["+ (i+1) + "/" + CONNECTION_TRIES + "] in" + WAITING_TIME_SEC + " seconds...");
                Delay.waitSeconds(WAITING_TIME_SEC);
            }
        }
        return null;
    }

    public static JSONObject getJSON(URL link) {
        return new JSONObject(getJsonString(link));
    }

    public static JSONArray getJSONArray(URL link) {
        return new JSONArray(getJsonString(link));
    }

    static String Read(Reader re) throws IOException {
        StringBuilder str = new StringBuilder();
        int temp;
        do {
            temp = re.read();
            str.append((char) temp);

        } while (temp != -1);
        return str.toString();
    }
}
