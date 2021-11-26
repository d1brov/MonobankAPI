package currency;

public class Currency {
    private String name;
    private String alphabeticCode;
    private int numericCode;

    public Currency(String name, String alphabeticCode, int numericCode) {
        this.name = name;
        this.alphabeticCode = alphabeticCode;
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public String getAlphabeticCode() {
        return alphabeticCode;
    }

    public int getNumericCode() {
        return numericCode;
    }
}
