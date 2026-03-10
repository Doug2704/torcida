package br.com.vascoparaiba.torcida.config;

import br.com.vascoparaiba.torcida.service.APIFootballService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheScheduler {

    private final APIFootballService service;

    public CacheScheduler(APIFootballService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 1000 * 60 * 60 * 6)
    public void refreshCache() throws Exception {
        service.getVascoMatches();
    }
}
