import com.opencsv.exceptions.CsvException;
import currency.CurrencyDecoder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {

        String currencyCodesFilePath = "C:\\Users\\NRD\\Desktop\\Hillel\\pets\\MonobankAPI\\src\\main\\java\\ISO4217.csv";
        System.out.println(new CurrencyDecoder(currencyCodesFilePath).getAlphabeticCode(4111));
    }
}