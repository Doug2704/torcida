package br.com.vascoparaiba.torcida.controller;

import br.com.vascoparaiba.torcida.service.APIFootballService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
public class APIFootballController {

    private final APIFootballService apiFootballService;

    public APIFootballController(APIFootballService service) {
        this.apiFootballService = service;
    }

    @GetMapping
    public ResponseEntity<?> getVascoMatchList() throws Exception {
        return ResponseEntity.ok(apiFootballService.getVascoMatches());
    }
}