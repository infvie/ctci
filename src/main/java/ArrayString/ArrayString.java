package ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayString {

    public static boolean allUnique(String str) {

        for (int i=0; i < str.length(); i++) {
            for (int j=i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }

    public static boolean checkPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);

        for (int i=0; i<str1.length(); i++)
            if (str1Arr[i] != str2Arr[i]) return false;

        return true;
    }

    public static char[] urlIfy(String str, int size) {
        char[] result = new char[str.length()];
        int i = 0;

        for (int s=0; s < size; s++) {
            if (str.charAt(s) == ' ') {
                result[i] = '%'; i++;
                result[i] = '0'; i++;
                result[i] = '2'; i++;
            } else {
                result[i] = str.charAt(s); i++;
            }
        }
        return result;
    }

    public static boolean palindromePermutation(String str) {
        str = str.replaceAll("\\s","");
        int l = str.length();

        int[] instances = new int[26];

        for (int i=0; i<str.length(); i++) {
            instances[str.charAt(i) - 'a'] += 1;
        }

        int nOdds = 0;
        for (int i: instances) {
            if (i % 2 != 0) nOdds++;
        }

        return (l % 2 == 1 && nOdds == 1) || (l % 2 == 0 && nOdds == 0);
    }

    public static boolean oneAway(String str1, String str2) {
        // check if they are the same
        if (str1.equals(str2)) return true;
        // check if they are more than 2 units away
        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        String largerStr = str1.length() >= str2.length() ? str1 : str2;
        String shorterStr = str1.length() < str2.length() ? str1 : str2;
        boolean edit = false;
        int j = 0;

        for (int i=0; i<largerStr.length(); i++) {
            if (j < shorterStr.length() && largerStr.charAt(i) == shorterStr.charAt(j)) {
                j++;
            } else {
                if (edit) {
                    return false;
                } else {
                    edit = true;
                }
            }

        }
        return true;
    }

    public static String compressString(String str) {
        // break up input
        char[] letters = str.toCharArray();

        // store results here
        StringBuilder result = new StringBuilder();

        // init vars for for loop
        char lastChar = letters[0];
        int count = 0;

        for (char c: letters) {
            if (c == lastChar) {
                count += 1;
            } else {
                // save results
                result.append(lastChar);
                result.append(count);
                // reset for next letter
                lastChar = c;
                count = 1;
            }
        }
        // save last letter
        result.append(lastChar);
        result.append(count);

        return (result.toString().length() < str.length()) ? result.toString() : str;
    }

    public static <T> void printMat(T[][] mat) {
        StringBuilder sb = new StringBuilder();

        int n = mat.length;

        for (T[] chars : mat) {
            for (T c: chars) {
                sb.append(c);
                sb.append(",");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void rotateMatrix(Character[][] mat) {
        printMat(mat);
        int n = mat.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                char temp = mat[i][j];
                mat[i][j] = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                mat[j][n - 1 - i] = temp;
            }
        }
        printMat(mat);
    }

    public static void zeroMatrix(Integer[][] mat) {
        printMat(mat);
        int n = mat.length;

        List<Integer> rowsToZero = new ArrayList<>();
        List<Integer> colsToZero = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    rowsToZero.add(i);
                    colsToZero.add(j);
                }
            }
        }

        for (int i: rowsToZero) {
            for (int j=0; j<n; j++) mat[i][j] = 0;
        }

        for (int j: colsToZero) {
            for (int i=0; i<n; i++) mat[i][j] = 0;
        }

        printMat(mat);
    }

    public static boolean isRotation(String str, String rot) {
        return (str.length() == rot.length()) && (str + str).contains(rot);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle","erbottlewat"));
    }
}
