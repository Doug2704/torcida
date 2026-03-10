package br.com.vascoparaiba.torcida.controller;

import br.com.vascoparaiba.torcida.entitites.Event;
import br.com.vascoparaiba.torcida.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Event event = eventService.findById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Event> events = eventService.findAll();
        return ResponseEntity.ok(events);
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        URI localURI = URI.create("/" + createdEvent.getId());
        return ResponseEntity.created(localURI).body(createdEvent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody Event event) {

        Event retrievdEvent = eventService.updateEvent(id, event);
        return ResponseEntity.ok(retrievdEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Evento excluído");
    }
}
