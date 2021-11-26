package currency;

import org.json.JSONObject;

public class CurrencyRecord {
    Currency currencyA;
    Currency currencyB;
    int date;
    double rateBuy;
    double rateSell;
    double rateCross;

    public CurrencyRecord(JSONObject jsonRecord, CurrencyDecoder currencyDecoder) {
        date = (Integer) jsonRecord.get("date");
        int currencyCodeA = (Integer) jsonRecord.get("currencyCodeA");
        int currencyCodeB = (Integer) jsonRecord.get("currencyCodeB");
        currencyA = currencyDecoder.getCurrency(currencyCodeA);
        currencyB = currencyDecoder.getCurrency(currencyCodeB);

        try {
            rateCross = Double.parseDouble(jsonRecord.get("rateCross").toString());
            rateBuy = Double.parseDouble(jsonRecord.get("rateBuy").toString());
            rateSell = Double.parseDouble(jsonRecord.get("rateSell").toString());
        }
        catch (Exception e){
        }
    }
}
