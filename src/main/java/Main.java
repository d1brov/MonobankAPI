import constants.Monobank;
import rest.RESTController;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;
import currency.CurrencyDecoder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        String header = RESTController.getJSONArray(Monobank.CURRENCY).toString();
        System.out.println(header);

        String currencyCodesFilePath = "C:\\Users\\NRD\\Desktop\\Hillel\\pets\\MonobankAPI\\src\\main\\java\\ISO4217.csv";
        System.out.println(new CurrencyDecoder(currencyCodesFilePath).getAlphabeticCode(4111));
    }
}