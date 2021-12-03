package entities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Client {
    String id;
    String name;
    ArrayList<Account> accounts;

    public Client(JSONObject client) {
        this.id = client.getString("clientId");
        this.name = client.getString("name");

        JSONArray accountsJson = client.getJSONArray("accounts");
        accounts = new ArrayList<>();
        for(int i = 0; i < accountsJson.length(); i++)
            this.accounts.add(new Account(accountsJson.getJSONObject(i)));
    }
}
