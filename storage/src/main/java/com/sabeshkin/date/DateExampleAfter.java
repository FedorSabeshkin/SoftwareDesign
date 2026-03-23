package com.sabeshkin.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateExampleAfter {

  public static void main(String[] args) {
    String dateString = "2024-05-13 14:30:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    formatter.withLocale(Locale.ROOT);
    ZoneId MoscowZoneId=  ZoneId.of("Europe/Moscow");
    LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
    ZonedDateTime zonedDateTime = localDateTime.atZone(MoscowZoneId);
    System.out.println("Date: " + zonedDateTime);
  }

}