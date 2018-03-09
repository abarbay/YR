package exceptions.faults;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaultList {

    public List<String> processing(String[] input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String[] row = null;
        List<String> results = new ArrayList<>();
        for (String str : input) {
            row = str.split(",");

            try {
                wordLenghtCheck(row);
                counterCheck(row);
                dateAndValueCheck(row);
                valueCheck(row);
                dateCheck(row);
            } catch (IllegalArgumentException iae) {
                results.add(iae.getMessage());
            } catch (IllegalStateException ise) {
            }


        }
        return results;
    }

    private void wordLenghtCheck(String[] row) {
        String result;
        if (row.length != 3) {
            result = row[0] + "," + ProcessingResult.WORD_COUNT_ERROR.getCode();
            throw new IllegalArgumentException(result, null);
        }

    }

    private void valueCheck(String[] row) {
        String result;
        try {
            Double.parseDouble(row[1]);
        } catch (NumberFormatException nfe) {
            result = row[0] + "," + ProcessingResult.VALUE_ERROR.getCode();
            throw new IllegalArgumentException(result, nfe);
        }
    }

    private void counterCheck(String[] row) {
        try {
            Integer.parseInt(row[0]);
        } catch (NumberFormatException nfe) {

            throw new IllegalStateException();
        }
    }


    private void dateCheck(String[] row) {
        String result;

        try {
            Date date = new SimpleDateFormat("yyyy.MM.dd.").parse(row[2]);
        } catch (ParseException pe) {
            result = row[0] + "," + ProcessingResult.DATE_ERROR.getCode();
            throw new IllegalArgumentException(result, pe);
        }
    }

    private void dateAndValueCheck(String[] row) {
        Throwable[] ex = new Throwable[2];
        String result;
        try {
            valueCheck(row);
        } catch (IllegalArgumentException iae) {
            if (iae.getCause() instanceof NumberFormatException) {
                ex[0] = iae.getCause();
            }
        }
        try {
            dateCheck(row);
        } catch (IllegalArgumentException iae) {
            if (iae.getCause() instanceof ParseException) {
                ex[1] = iae.getCause();
            }
        }
        if (ex[0] != null && ex[1] != null) {
            result = row[0] + "," + ProcessingResult.VALUE_AND_DATE_ERROR.getCode();
            throw new IllegalArgumentException(result);
        }

    }


}
