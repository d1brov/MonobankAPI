package entities;

import currency.Currency;
import currency.CurrencyDecoder;
import org.json.JSONObject;

/*
{
      "id": "kKGVoZuHWzqVoZuH",
      "balance": 10000000,
      "creditLimit": 10000000,
      "type": "black",
      "currencyCode": 980,
      "cashbackType": "UAH"
    }
*/

public class Account {
    String id;
    String iban;
    String type;
    int balance;
    int creditLimit;
    Currency currency;
    String cashbackType;

    public Account(JSONObject account) {
        this.id = account.getString("id");
        this.iban = account.getString("iban");
        this.type = account.getString("type");
        this.balance = account.getInt("balance");
        this.creditLimit = account.getInt("creditLimit");
        this.currency = CurrencyDecoder.getCurrency(account.getInt("currencyCode"));
        this.cashbackType = account.getString("cashbackType");
    }
}
