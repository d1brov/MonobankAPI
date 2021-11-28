package currency;

import org.json.JSONObject;

public class CurrencyRecord {
    private Currency currencyA;
    private Currency currencyB;
    private int date;
    private double rateBuy;
    private double rateSell;
    private double rateCross;

    public CurrencyRecord(JSONObject jsonRecord, CurrencyDecoder currencyDecoder) {
        date = (Integer) jsonRecord.get("date");
        int currencyCodeA = (Integer) jsonRecord.get("currencyCodeA");
        int currencyCodeB = (Integer) jsonRecord.get("currencyCodeB");
        currencyA = currencyDecoder.getCurrency(currencyCodeA);
        currencyB = currencyDecoder.getCurrency(currencyCodeB);

        if(jsonRecord.has("rateBuy"))
            rateBuy = Double.parseDouble(jsonRecord.get("rateBuy").toString());

        if(jsonRecord.has("rateSell"))
            rateSell = Double.parseDouble(jsonRecord.get("rateSell").toString());

        if(jsonRecord.has("rateCross"))
            rateCross = Double.parseDouble(jsonRecord.get("rateCross").toString());
        else
            rateCross = (rateBuy + rateSell) / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(currencyA.getAlphabeticCode());
        sb.append("\t");
        sb.append(currencyB.getAlphabeticCode());
        sb.append("\t");
        sb.append(date);
        sb.append("\t");
        sb.append(rateCross);
        return sb.toString();
    }
}
