package rest;

import org.json.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class RESTController {

    public static JSONObject getJSON(String link) throws IOException {
        InputStream input = new URL(link).openStream();
        try {
            BufferedReader re = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String Text = Read(re);
            JSONObject json = new JSONObject(Text);
            return json;
        } catch (Exception e) {
            return null;
        } finally {
            input.close();
        }
    }

    public static JSONArray getJSONArray(String link) throws IOException {
        InputStream input = new URL(link).openStream();
        try {
            BufferedReader re = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String Text = Read(re);
            return new JSONArray(Text);
        } catch (Exception e) {
            return null;
        } finally {
            input.close();
        }
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
