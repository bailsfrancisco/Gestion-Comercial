package ar.com.gestioncomercial.utils;

import ar.com.gestioncomercial.exception.NullOrEmptyException;

public class StringUtils {

    public static void areNullOrEmpty(String... toTest) throws NullOrEmptyException {
        if (org.apache.commons.lang3.StringUtils.isAllEmpty(toTest)){
            throw new  NullOrEmptyException();
        }
        for(String str: toTest){
            if(org.apache.commons.lang3.StringUtils.containsOnly(str, " ")){
                throw new  NullOrEmptyException();
            }
        }
    }

}
