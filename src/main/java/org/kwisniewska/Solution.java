package org.kwisniewska;

public class Solution {
  public static void main(String[] args) {
    printBonusDatesBetween(2020, 2015);
    printBonusDatesBetween(2010, 2015);
  }

  private static final int MIN_YEAR = 1800;
  private static final int MAX_YEAR = 2200;
  private static final int NUMBER_OF_MONTHS = 12;
  public static final String ERROR_MESSAGE = "Invalid data";

  public static void printBonusDatesBetween(int fromYear, int toYear) {
    if (fromYear > toYear || fromYear < MIN_YEAR || toYear > MAX_YEAR) {
      System.out.println(ERROR_MESSAGE);
    } else {
      for (int year = fromYear; year <= toYear; year++) {
        for (int month = 1; month <= NUMBER_OF_MONTHS; month++) {
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