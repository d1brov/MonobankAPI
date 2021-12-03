import constants.Monobank;
import constants.SensitiveData;
import currency.CurrencyDecoder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.opencsv.exceptions.CsvException;
import entities.Client;
import org.json.JSONArray;
import org.json.JSONObject;
import rest.RESTController;

public class Main {
    public static void main(String[] args) throws IOException, CsvException, InterruptedException, URISyntaxException {

        String currencyCodesFilePath = "ISO4217.csv";
        String merchantCodesFilePath = "ISO18245.csv";
        CurrencyDecoder currencyDecoder = new CurrencyDecoder(currencyCodesFilePath);

        JSONObject clientInfoJson = RESTController.getClientInfo(SensitiveData.X_TOKEN);
        Client c = new Client(clientInfoJson);

        System.out.println();
    }
}