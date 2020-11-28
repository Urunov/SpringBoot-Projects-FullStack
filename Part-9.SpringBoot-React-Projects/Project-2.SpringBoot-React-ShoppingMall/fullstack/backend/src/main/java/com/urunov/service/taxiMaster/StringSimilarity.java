package com.urunov.service.taxiMaster;

import org.springframework.security.core.parameters.P;

import java.util.Comparator;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */


public class StringSimilarity<T> implements Comparator<Address> {


    private String baseToCompare;

    public StringSimilarity(String baseToCompare){
        this.baseToCompare = baseToCompare;
    }
    /*
     * Calculates the similarity (a number within 0 and 1) between two strings.
     */

    public static double similarity(String s1, String s2)
    {
        String longger = s1;
        String shorter = s2;
        if(s1.length() < s2.length()) { // longer should always have greater length
            longger= s2;
            shorter = s1;
        }

        int longgerLength = longger.length();
       if(longgerLength == 0) {
           return 1.0; /* both strings are zero length;*/
           /* // If you have Apache Commons Text, you can use it to calculate the edit distance:
	    LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
	    return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength; */
       }
           return (longgerLength - editDistance(longger, shorter)) / (double)longgerLength;

    }

    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;

            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;

                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;

                        costs[j - 1] = lastValue;
                        lastValue = newValue;

                    }
                }
            }
                if (i > 0)
                    costs[s2.length()] = lastValue;
         }

            return costs[s2.length()];
        }



    public static double max(double x, double y) {
        return x>y?x:y;
    }

    public static double min(double x, double y) {
        return x>y?y:x;
    }

    public static double editDistanceAll(String s1, String s2) {
        return Math.round(editDistance(s1, s2) / max(s1.length(), s2.length()) * 100);
    }

    public static String clean(String s) {
        String ss;
        ss = s.replace(".", " ").replace(",", " ").replace(";", " ").replace("*", " ").replace("#", " ").replace("-", " ");
        return ss;
    }

    public static double editDistanceWord(String s1, String s2) {
        String[] w1 = clean(s1).split("\\s+");
        String[] w2 = clean(s2).split("\\s+");

        for (int i = 0; i < w1.length; i++) {
            for (int j = 0; j < w2.length; j++)
                if (w1[i].toLowerCase().equals(w2[j].toLowerCase())) {
                    w1[i] = "";
                    w2[j] = "";
                    break;
                }
        }

        double d = 0.0;
        int count = 0;
        int w1l = w1.length>0?w1.length:1;
        int w2l = w2.length>0?w2.length:1;

        for (int i = 0; i < w1.length; i++)
            for (int j = 0; j < w2.length; j++) {
                if (!w1[i].isEmpty() && !w2[j].isEmpty())
                    d = d + editDistance(w1[i].toLowerCase(), w2[j].toLowerCase()) / max(w1[i].length(), w2[j].length());
                else
                if (w1[i].isEmpty() && w2[j].isEmpty());
                else
                if (w1[i].isEmpty())
                    d = d + 1.0 / w1l;
                else
                if (w2[j].isEmpty())
                    d = d + 1.0 / w2l;
                count++;
            }

        if (count == 0)
            count = 1;
        return Math.round(d / count * 100);
    }


    public static double similarity2(String s1, String s2) {
        return editDistanceWord(s1, s2);
    }

    @Override
    public int compare(Address o1, Address o2) {
        double f1 = similarity2(o1.getAddr(), baseToCompare);
        double f2 = similarity2(o2.getAddr(), baseToCompare);

        if (f1 > f2)
            return 1;
        else
        if (Math.abs(f1 - f2) < 0.000001)
            return 0;
        else
            return -1;
    }

}
