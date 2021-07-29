package ca.jrvs.apps.practice;

import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc {

  /**
   * return true if filename extension is jpg or jpeg (case insensitive)
   *
   * @param filename
   * @return
   */
  @Override
  public boolean matchJpeg(String filename) {
    return Pattern.matches("\\b.*\\.\\bjpe?g\\b", filename);
  }

  /**
   * return true if ip is valid
   * to simplify the problem, IP address range is from 0.0.0.0 to 999.999.999.999
   *
   * @param ip
   * @return
   */
  @Override
  public boolean matchIp(String ip) {
    return Pattern.matches("\\b[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\b", ip);
  }

  /**
   * return true if line is empty (e.g. empty, white space, tabs, etc..)
   *
   * @param line
   * @return
   */
  @Override
  public boolean isEmptyLine(String line) {
    return Pattern.matches("^\\s*$", line);
  }
}
