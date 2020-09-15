package com.test.testapp.katas;
import java.util.*;
import java.util.stream.Collectors;

public class BifidCipher {
    private static final Map<String, String> codeMap = new HashMap<>();
    private static final Map<String, String> decodeMap = new HashMap<>();

    public static String encodeBifid (String key, String message) {
        if(message.length() == 0) {
            return "";
        }
        key = prepareInputString(key);
        message = prepareInputString(message);
        String[][] defaultCodeMap = getDefaultCodeArray();

        generateMaps(defaultCodeMap, key);

        List<String> unencoded = Arrays.stream(message.split(""))
                .map(a -> codeMap.get(a))
                .collect(Collectors.toList());

        String row = unencoded.stream().map(a -> String.valueOf(a.charAt(0))).collect(Collectors.joining(""));
        String column = unencoded.stream().map(a -> String.valueOf(a.charAt(1))).collect(Collectors.joining(""));
        row = row + column;
        String result = "";
        for (int i = 0; i < row.length(); i+=2) {
            String currentString = row.substring(i,i+2);
            result += decodeMap.get(currentString);
        }
        return result;
    }

    public static String decodeBifid (String key, String message) {
        if(message.length() == 0) {
            return "";
        }
        key = prepareInputString(key);
        message = prepareInputString(message);
        String[][] defaultCodeMap = getDefaultCodeArray();

        generateMaps(defaultCodeMap, key);
        List<String> encoded = Arrays.stream(message.split(""))
                .map(a -> codeMap.get(a))
                .collect(Collectors.toList());

        String fullEncoded = encoded.stream().collect(Collectors.joining(""));
        String row = fullEncoded.substring(0, fullEncoded.length()/2);
        String column = fullEncoded.substring(fullEncoded.length()/2);
        String result = "";
        for (int i = 0; i < fullEncoded.length()/2; i++) {
            String currentString = decodeMap.get(String.valueOf(row.charAt(i))
                    + column.charAt(i)
            );
            result += currentString;
        }
        return result;
    }


    public static String prepareInputString(String str) {
        return str.replaceAll(" ", "").toUpperCase().replaceAll("J", "I");
    }

    public static String[][] getDefaultCodeArray() {
        String[] row0 = {"A", "B", "C", "D", "E"};
        String[] row1 = {"F", "G", "H", "I", "K"};
        String[] row2 = {"L", "M", "N", "O", "P"};
        String[] row3 = {"Q", "R", "S", "T", "U"};
        String[] row4 = {"V", "W", "X", "Y", "Z"};
        return new String[][]{row0, row1, row2, row3, row4};
    }

    public static Map<String, String> generateMaps(String[][] completeTable, String key) {
        String finalTableString = getFinalTableString(key, completeTable);
        int stringPosition = 0;
        for(int m = 0; m < 5; m++) {
            for (int n=0; n < 5; n++) {
                decodeMap.put(String.valueOf(m) + n, String.valueOf(finalTableString.charAt(stringPosition)));
                codeMap.put(String.valueOf(finalTableString.charAt(stringPosition)), String.valueOf(m) + n);
                stringPosition++;
            }
        }
        return decodeMap;
    }

    private static String getFinalTableString(String key, String[][] completeTable) {
        String completeTableFlattened = "";
        for(int k = 0; k < 5; k++) {
            for(int l = 0; l < 5; l++) {
                completeTableFlattened += completeTable[k][l];
            }
        }
        Set<String> allCharsInDefaultTable = new HashSet<>(Arrays.asList(completeTableFlattened.split("")));
        Set<String> allCharsInKey = new LinkedHashSet<>(Arrays.asList(key.split("")));
        allCharsInDefaultTable.removeAll(allCharsInKey);
        return String.join("", allCharsInKey) + String.join("", allCharsInDefaultTable);
    }

}