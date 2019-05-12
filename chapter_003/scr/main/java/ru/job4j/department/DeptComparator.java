package ru.job4j.department;

import java.util.Comparator;

public class DeptComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result;
        if (o1.length() == o2.length()) {
            result = o2.compareTo(o1);
        } else {
            int size = Math.min(o1.length(),o2.length());
            String left = o1.substring(0, size);
            String right = o2.substring(0, size);
            if (left.compareTo(right) == 0 && o1.length() > o2.length()) {
                result = 1;
            } else if (left.compareTo(right) == 0 && o1.length() < o2.length()){
                result = -1;
            } else {
                result = o2.compareTo(o1);
            }
        }
        return result;
    }
}
