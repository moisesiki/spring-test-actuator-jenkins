package com.rintio.tigry.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@Slf4j
public class LogGenerationTask {

	private static final Random RANDOM = new Random();

	@Scheduled(fixedDelayString = "${schedule.delay}")
	public void generateLog() {
		int level = RANDOM.nextInt(5);
		switch (level) {
			case 0:
				// Message trace
				log.trace("A tiny bity action was taken by the system.");
				break;
			case 1:
				// Message info
				log.info("Just a normal message. Nothing to fret about !");
				break;
			case 2:
				// Message debug
				log.debug("I don't know if anithing happen but imma check it anyway !");
				break;
			case 3:
				// Message warn
				log.warn("Nothing blow ! For the moment.");
				break;
			case 4:
				// Message error
				log.error("Oops ! Something bad happen. Please check it.");
				break;
			default:
				break;
		}

	}
}
