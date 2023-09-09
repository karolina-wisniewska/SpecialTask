package org.kwisniewska;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

class SolutionTest {

  @Test
  void givenCorrectInput_shouldPrintCorrectDates() throws Exception{
    //given
    int fromYear = 2010;
    int toYear = 2015;
    String expected = "2010-01-02\n2011-11-02";

    //when
    String text = tapSystemOut(() -> {
      Solution.printBonusDatesBetween(fromYear, toYear);
    });

    //then
    Assert.assertEquals(expected, text.trim());
  }

  @Test
  void givenDatesInWrongOrder_shouldPrintErrorMessage() throws Exception{
    //given
    int fromYear = 2020;
    int toYear = 2015;
    String expected = "Invalid data";

    //when
    String text = tapSystemOut(() -> {
      Solution.printBonusDatesBetween(fromYear, toYear);
    });

    //then
    Assert.assertEquals(expected, text.trim());
  }

  @Test
  void givenTooSmallDate_shouldPrintErrorMessage() throws Exception{
    //given
    int fromYear = 1700;
    int toYear = 2015;
    String expected = "Invalid data";

    //when
    String text = tapSystemOut(() -> {
      Solution.printBonusDatesBetween(fromYear, toYear);
    });

    //then
    Assert.assertEquals(expected, text.trim());
  }
  @Test
  void givenTooLargeDate_shouldPrintErrorMessage() throws Exception{
    //given
    int fromYear = 2020;
    int toYear = 2250;
    String expected = "Invalid data";

    //when
    String text = tapSystemOut(() -> {
      Solution.printBonusDatesBetween(fromYear, toYear);
    });

    //then
    Assert.assertEquals(expected, text.trim());
  }
}