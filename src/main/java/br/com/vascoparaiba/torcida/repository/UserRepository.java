package br.com.vascoparaiba.torcida.repository;

import br.com.vascoparaiba.torcida.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
