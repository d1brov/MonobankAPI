import constants.Monobank;
import currency.CurrencyDecoder;
import java.io.IOException;
import java.net.URI;

import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import rest.RESTController;

public class Main {
    public static void main(String[] args) throws IOException, CsvException, InterruptedException {

        String currencyCodesFilePath = "ISO4217.csv";
        String merchantCodesFilePath = "ISO18245.csv";
        CurrencyDecoder currencyDecoder = new CurrencyDecoder(currencyCodesFilePath);

        JSONArray ja = RESTController.getJSONArray(URI.create(Monobank.CURRENCY));

        System.out.println();
    }
}