package LLists;

import java.util.*;

public class LLists {

    public static <T> void print(List<T> list) {
        StringBuilder sb = new StringBuilder();

        for (T e: list) {
            sb.append(e);
        }

        System.out.println(sb);
    }

    public static List removeDups(List<Integer> list) {
        return new ArrayList(new HashSet<Integer>(list));
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(6,4,2,6,3,6));

    }
}
