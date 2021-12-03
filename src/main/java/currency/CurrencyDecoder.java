package currency;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyDecoder {

    private static Map<Integer, Currency> currencies;

    public CurrencyDecoder(String currencyCodesFilePath) throws IOException, CsvException {
        FileReader fileReader = new FileReader(currencyCodesFilePath);
        CSVReader csvReader = new CSVReader(fileReader);
        List<String[]> currencyCodes = csvReader.readAll();

        currencies = new HashMap<Integer, Currency>();
        for(String[] s: currencyCodes){
            String currencyName = s[0];
            String alphabeticCode = s[1];
            int numericCode = Integer.parseInt(s[2]);
            Currency c = new Currency(currencyName, alphabeticCode, numericCode);
            currencies.put(numericCode, c);
        }

        csvReader.close();
        fileReader.close();
    }

    public static String getAlphabeticCode(int currencyCode){
        return currencies.get(currencyCode).getAlphabeticCode();
    }

    public static Currency getCurrency(int currencyCode){
        return currencies.get(currencyCode);
    }
}
