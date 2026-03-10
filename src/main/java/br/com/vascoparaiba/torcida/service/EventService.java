package br.com.vascoparaiba.torcida.service;

import br.com.vascoparaiba.torcida.entitites.Event;
import br.com.vascoparaiba.torcida.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        System.out.println(event.getDate());
        return eventRepository.save(event);
    }

    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Long id, Event event) {
        Event retrievedEvent = findById(id);

        if (event.getLocal() != null) retrievedEvent.setLocal(event.getLocal());
        if (event.getTitle() != null) retrievedEvent.setTitle(event.getTitle());
        if (event.getDate() != null) retrievedEvent.setDate(event.getDate());
        if (event.getAddress() != null) retrievedEvent.setAddress(event.getAddress());
        return eventRepository.save(retrievedEvent);
    }

    public void deleteEvent(Long id) {
        Event event = findById(id);
        eventRepository.delete(event);
    }
}
