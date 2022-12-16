package practice3_new.part3;

import java.util.Currency;

public abstract class CurrencyConverter {
    public final Currency incomingCurrency;
    public final Currency resultingCurrency;

    public CurrencyConverter(Currency incomingCurrency, Currency resultingCurrency) {
        this.incomingCurrency = incomingCurrency;
        this.resultingCurrency = resultingCurrency;
    }

    public abstract double convert(double incomingValue);
}

class DollarToRublesConverter extends CurrencyConverter {
    public DollarToRublesConverter() {
        super(Currency.getInstance("USD"), Currency.getInstance("RUB"));
    }

    @Override
    public double convert(double incomingValue) {
        return incomingValue * 58.2;
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new DollarToRublesConverter();
        var dollars = 123.0;
        System.out.println("Dollars: " + dollars);
        System.out.println("Rubles: " + converter.convert(dollars));
    }
}
