package spring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Created 02 / 04 / 2020 - 5:43 PM
 * @project SpringSchedule
 * @Author Hamdamboy
 */
@Component
public class ScheduleTask {
    //
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);

    private static final DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        LOGGER.info("Fixed Rate Task:: Exceution time - {} ", dataFormat.format(LocalDateTime.now()));
    }
}
