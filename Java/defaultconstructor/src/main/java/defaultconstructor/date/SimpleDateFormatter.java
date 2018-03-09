package defaultconstructor.date;

public class SimpleDateFormatter {

    public SimpleDateFormatter(){};


    public String formatDateString(SimpleDate simpleDate){
        return simpleDate.getYear()+"-"+simpleDate.getMonth()+"-"+simpleDate.getDay();
    }
    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate){
        String result="";
        if(countryCode==CountryCode.HU){result= simpleDate.getYear()+"-"+simpleDate.getMonth()+"-"+simpleDate.getDay();}
        else if(countryCode==CountryCode.EN){result= simpleDate.getDay()+"-"+simpleDate.getMonth()+"-"+simpleDate.getYear();}
        else if(countryCode==CountryCode.US){result= simpleDate.getMonth()+"-"+simpleDate.getDay()+"-"+simpleDate.getYear();}
        return result;
    }


}
