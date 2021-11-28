import constants.Monobank;
import currency.CurrencyDecoder;
import currency.CurrencyRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import rest.RESTController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {

        String currencyCodesFilePath = "ISO4217.csv";
        CurrencyDecoder currencyDecoder = new CurrencyDecoder(currencyCodesFilePath);

        JSONArray jsonArray = RESTController.getJSONArray(new URL(Monobank.CURRENCY));

        ArrayList<CurrencyRecord> currencyRecords = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            CurrencyRecord currencyRecord = new CurrencyRecord(jsonArray.getJSONObject(i), currencyDecoder);
            currencyRecords.add(currencyRecord);

            System.out.println(currencyRecord.toString());
        }

        System.out.println();
    }
}