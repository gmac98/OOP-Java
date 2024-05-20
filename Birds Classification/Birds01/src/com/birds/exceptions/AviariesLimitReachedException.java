package com.birds.exceptions;

/** This class gives exception when maximum limit has been reached for the aviary. */
public class AviariesLimitReachedException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * This method gives exception on reaching maximum limit for an aviary.
   *
   * @param s passes the aviary to check its limit
   */
  public AviariesLimitReachedException(String s) {
    super(s);
  }
}
