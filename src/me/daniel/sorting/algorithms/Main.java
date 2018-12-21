package me.daniel.sorting.algorithms;

import java.util.ArrayList;

public class Main {

  final static int N = 100000;

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int r = (int) (Math.random() * 1000);
      list.add(r);
    }

    System.out.println(list);
    long start = System.currentTimeMillis();
    list = bubble_sort(list);
    long end = System.currentTimeMillis();
    System.out.println(list);
    double timeS = (double) (end - start) / 1000;
    double timeM = timeS / 60;
    if (timeS < 60) {
      System.out.println("That took: " + timeS + " seconds!");
    } else if (timeS >= 60) {
      System.out.println("That took: " + timeM + " minutes!");
    }

    long start2 = System.currentTimeMillis();
    System.out.println(selection_sort(list));
    long end2 = System.currentTimeMillis();
    double time2S = (double) (end2 - start2) / 1000;
    double time2M = timeS / 60;
    if (time2S < 60) {
      System.out.println("That took: " + time2S + " seconds!");
    } else if (time2S >= 60) {
      System.out.println("That took: " + time2M + " minutes!");
    }

  }

  public static ArrayList<Integer> bubble_sort(ArrayList<Integer> list) {
    while (!isSorted(list)) {
      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i) > list.get(i + 1)) {
          int tmp = list.get(i);
          list.set(i, list.get(i + 1));
          list.set(i + 1, tmp);
        }
      }
    }
    return list;
  }

  public static ArrayList<Integer> selection_sort(ArrayList<Integer> list) {
    ArrayList<Integer> sorted = new ArrayList<>();
    sorted.addAll(list);

    int n = sorted.size();
    for (int i = 0; i < n - 1; i++) {
      // Find the minimum element in unsorted array
      int min_id = i;
      for (int j = i + 1; j < n; j++)
        if (sorted.get(j) < sorted.get(min_id)) {
          min_id = j;
        }
      // Swap the found minimum element with the first
      // element
      int temp = sorted.get(min_id);
      sorted.set(min_id, sorted.get(i));
      sorted.set(i, temp);
    }
    return sorted;
  }

  //checks if array is sorted for bubble sort
  public static boolean isSorted(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) > list.get(i + 1)) {
        return false;
      }
    }
    return true;
  }
}
