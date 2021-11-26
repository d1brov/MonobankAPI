package currency;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDecoder {

    private List<Currency> currencies;

    public CurrencyDecoder(String currencyCodesFilePath) throws IOException, CsvException {
        FileReader fileReader = new FileReader(currencyCodesFilePath);
        CSVReader csvReader = new CSVReader(fileReader);
        List<String[]> currencyCodes = csvReader.readAll();

        currencies = new ArrayList<>(currencyCodes.size());
        for(String[] s: currencyCodes){
            String currencyName = s[0];
            String alphabeticCode = s[1];
            int numericCode = Integer.parseInt(s[2]);
            Currency c = new Currency(currencyName, alphabeticCode, numericCode);
            currencies.add(c);
        }

        csvReader.close();
        fileReader.close();
    }

    public String getAlphabeticCode(int currencyCode){
        for(Currency c: currencies){
            if(c.getNumericCode() == currencyCode)
                return c.getAlphabeticCode();
        }
        return null;
    }

    public Currency getCurrency(int currencyCode){
        for(Currency c: currencies){
            if(c.getNumericCode() == currencyCode)
                return c;
        }
        return null;
    }
}
