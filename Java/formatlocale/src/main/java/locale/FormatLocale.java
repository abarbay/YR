package locale;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatLocale {

    public String formatCurrency(double number, Locale locale){
        if(locale==null){throw new NullPointerException("Locale must not be null");}
        NumberFormat formatCurr=NumberFormat.getCurrencyInstance(locale);
        return formatCurr.format(number);
    }

    public String formatCurrency(double number){
        return formatCurrency(number, Locale.getDefault());
    }

    public String formatCurrencyByLanguage(double number, String language, String country){
        if(!localePresent(new Locale(language, country))){throw new IllegalArgumentException("Incorrect arguments!");}
        if(isEmpty(language)|| isEmpty(country)){throw new IllegalArgumentException("Incorrect arguments!");}
        return formatCurrency(number,new Locale(language, country));
    }

    public String formatPercentage(double number, Locale locale){
        NumberFormat formatPercentage=NumberFormat.getPercentInstance(locale);
        return formatPercentage.format(number);

    }

    public String formatPercentage(double number){
        return formatPercentage(number,Locale.getDefault());
    }

    public String formatPercentageByLanguage(double number, String language, String country){
        if (!localePresent(new Locale(language, country))) {throw new IllegalArgumentException("Incorrect arguments!");}
        if (isEmpty(language) || isEmpty(country)) {throw new IllegalArgumentException("Incorrect arguments!");}
        return formatPercentage(number, new Locale(language, country));
    }

    public String formatNumber(double number, Locale locale){
        if(locale==null){throw new NullPointerException("Locale must not be null");}
        NumberFormat formatNum=NumberFormat.getNumberInstance(locale);
        formatNum.setMaximumFractionDigits(2);
        return formatNum.format(number);
    }

    private boolean localePresent(Locale locale){
        Locale[] locales= Locale.getAvailableLocales();
        for(Locale loc:locales){
            if(loc.equals(locale)){return true;
            }
        }
        return false;
    }
    private boolean isEmpty(String str){
        if(str==null || str==""){
            return true;
        }
        return false;
    }

}
