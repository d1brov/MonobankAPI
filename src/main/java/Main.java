import constants.Monobank;
import rest.RESTController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        String header = RESTController.getJSONArray(Monobank.CURRENCY).toString();
        System.out.println(header);
    }
}