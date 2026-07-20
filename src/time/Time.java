package time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        System.out.println(LocalDateTime.now().format(formatter));
        LocalDate curDate = LocalDateTime.now().toLocalDate();
        System.out.println(curDate);

        ZonedDateTime zoned1 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC-3"));
        ZonedDateTime zoned2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Moscow"));
    }
}
