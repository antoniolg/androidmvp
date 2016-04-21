package com.antonioleiva.mvpexample.app.main;

/**
 * Created by danielgomez22 on 4/20/16.
 */
public class ItemFormatter {
  public String formatMessage(int position) {
    return String.format("Position %d clicked", position);
  }
}
