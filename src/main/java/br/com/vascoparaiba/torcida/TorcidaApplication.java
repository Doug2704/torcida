package br.com.vascoparaiba.torcida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class TorcidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorcidaApplication.class, args);
	}

}
