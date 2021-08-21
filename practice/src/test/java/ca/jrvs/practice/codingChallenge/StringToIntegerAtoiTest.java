package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringToIntegerAtoiTest {

  @Test
  public void myAtoi() {
    StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
    String s1 = "42";
    int result1 = stringToIntegerAtoi.myAtoi(s1);
    assertEquals(42, result1);
    String s2 = "   -42";
    int result2 = stringToIntegerAtoi.myAtoi(s2);
    assertEquals(-42, result2);
    String s3 = "4193 with words";
    int result3 = stringToIntegerAtoi.myAtoi(s3);
    assertEquals(4193, result3);
    String s4 = "words and 987";
    int result4 = stringToIntegerAtoi.myAtoi(s4);
    assertEquals(0, result4);
    String s5 = "-91283472332";
    int result5 = stringToIntegerAtoi.myAtoi(s5);
    assertEquals(Integer.MIN_VALUE, result5);
    String s6 = "91283472332";
    int result6 = stringToIntegerAtoi.myAtoi(s6);
    assertEquals(Integer.MAX_VALUE, result6);
  }

  @Test
  public void myAtoiAscii() {
    StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
    String s1 = "42";
    int result1 = stringToIntegerAtoi.myAtoiAscii(s1);
    assertEquals(42, result1);
    String s2 = "   -42";
    int result2 = stringToIntegerAtoi.myAtoiAscii(s2);
    assertEquals(-42, result2);
    String s3 = "4193 with words";
    int result3 = stringToIntegerAtoi.myAtoiAscii(s3);
    assertEquals(4193, result3);
    String s4 = "words and 987";
    int result4 = stringToIntegerAtoi.myAtoiAscii(s4);
    assertEquals(0, result4);
    String s5 = "-91283472332";
    int result5 = stringToIntegerAtoi.myAtoiAscii(s5);
    assertEquals(Integer.MIN_VALUE, result5);
    String s6 = "91283472332";
    int result6 = stringToIntegerAtoi.myAtoiAscii(s6);
    assertEquals(Integer.MAX_VALUE, result6);
  }
}
