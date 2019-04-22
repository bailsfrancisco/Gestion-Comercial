package ar.com.gestioncomercial.utils;

public class StringUtils {
    // Esto deberia dar true or false la exception esta de mas
    public static boolean isNullOrEmpty(String toTest) {
        return  (org.apache.commons.lang3.StringUtils.isAllEmpty(toTest) ||
        (org.apache.commons.lang3.StringUtils.containsOnly(toTest, " ")));
    }
}
