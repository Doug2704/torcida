package br.com.vascoparaiba.torcida.repository;

import br.com.vascoparaiba.torcida.entitites.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
