package catalog;

import java.util.List;

public class Validators {
    public static boolean isBlank(String string) {
        boolean result = false;
        if (string == null || string.trim().equals("")) {
            result = true;
        }
        return result;
    }

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }
}

