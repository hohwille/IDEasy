package com.devonfw.tools.ide.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Utility class for operations on data and time (java.time).
 */
public final class DateTimeUtil {

  private static final DateTimeFormatter DATE_FORMATTER_PATH = new DateTimeFormatterBuilder().appendPattern("YYYY/MM/dd")
      .toFormatter();

  private static final DateTimeFormatter DATE_FORMATTER_NAME = new DateTimeFormatterBuilder().appendPattern("YYYY-MM-dd")
      .toFormatter();

  private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder().appendPattern("HH-mm-ss")
      .toFormatter();

  // construction forbidden
  private DateTimeUtil() {

  }

  /**
   * @param start the first {@link Instant}.
   * @param end the second {@link Instant}.
   * @return {@code true} if the first {@link Instant} is after the second.
   */
  public static boolean isAfter(Instant start, Instant end) {

    if ((start == null) || (end == null)) {
      return false;
    }
    return start.isAfter(end);
  }

  /**
   * @param start the first {@link Instant}.
   * @param end the second {@link Instant}.
   * @return {@code true} if the first {@link Instant} is before the second.
   */
  public static boolean isBefore(Instant start, Instant end) {

    if ((start == null) || (end == null)) {
      return false;
    }
    return start.isBefore(end);
  }

  /**
   * @param start the start {@link Instant}.
   * @param end the end {@link Instant}.
   * @param duration the {@link Duration} to compare to.
   * @return {@code 0} if the {@link Duration} from {@code start} to {@code end} is equal to the given {@link Duration}, negative value if less, positive value
   *     is greater and {@code null} if one of the given values was {@code null}.
   */
  public static Integer compareDuration(Instant start, Instant end, Duration duration) {

    if ((start == null) || (end == null) || (duration == null)) {
      return null;
    }
    Duration delta = Duration.between(start, end);
    return Integer.valueOf(delta.compareTo(duration));
  }

  /**
   * @param temporal the {@link LocalDateTime} to format as date.
   * @param dirs {@code true} to use "/" as separator to create subfolders per year, month, and date, {@code false} otherwise.
   * @return the {@link LocalDateTime} formatted as date in the format YYYY-MM-dd or YYYY/MM/dd.
   */
  public static String formatDate(LocalDateTime temporal, boolean dirs) {

    if (dirs) {
      return temporal.format(DATE_FORMATTER_PATH);
    } else {
      return temporal.format(DATE_FORMATTER_NAME);
    }
  }

  /**
   * @param temporal the {@link LocalDateTime} to format as time.
   * @return the {@link LocalDateTime} formatted as time in the format HH-mm-ss.
   */
  public static String formatTime(LocalDateTime temporal) {

    return temporal.format(TIME_FORMATTER);
  }

}
