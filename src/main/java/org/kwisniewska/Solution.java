package org.kwisniewska;

public class Solution {
  public static void main(String[] args) {
    printBonusDatesBetween(2020, 2015);
    printBonusDatesBetween(2010, 2015);
  }

  public static void printBonusDatesBetween(int fromYear, int toYear) {
    if (fromYear > toYear) {
      System.out.println("Invalid data");
    }

    for (int year = fromYear; year <= toYear; year++) {
      for (int month = 1; month <= 12; month++) {
        int daysInMonth = calculateDaysInMonth(month, year);
        for (int day = 1; day <= daysInMonth; day++) {
          String dateAsString = String.format("%4d%02d%02d", year, month, day);
          if (isPalindrome(dateAsString)) {
            String formattedDate = String.format("%4d-%02d-%02d", year, month, day);
            System.out.println(formattedDate);
          }
        }
      }
    }
  }

  private static boolean isPalindrome(String dateAsString) {
    int left = 0;
    int right = dateAsString.length() - 1;
    while (left < right) {
      if (dateAsString.charAt(left) != dateAsString.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  private static int calculateDaysInMonth(int month, int year) {
    if (month == 2) {
      return isLeap(year) ? 29 : 28;
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    return 31;
  }

  private static boolean isLeap(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }


}