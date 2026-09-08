/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CollectionsLab;

/**
 *
 * @author Calypso Computers
 */;

public class StringPerformance {

    // Immutable String concatenation - O(n^2)
    public static String buildString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + i;   // creates a NEW String object every single time
        }
        return s;
    }

    // Mutable StringBuilder - O(n)
    public static String buildStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);   // modifies the SAME object in place
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 10000;

        long start1 = System.nanoTime();
        buildString(n);
        long end1 = System.nanoTime();
        System.out.println("String concatenation time: " + (end1 - start1) / 1_000_000.0 + " ms");

        long start2 = System.nanoTime();
        buildStringBuilder(n);
        long end2 = System.nanoTime();
        System.out.println("StringBuilder time: " + (end2 - start2) / 1_000_000.0 + " ms");
    }
}
    

