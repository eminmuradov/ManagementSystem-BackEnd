package az.rest.repository;

import az.rest.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository  extends JpaRepository<Registration,Long> {

    Optional<Registration> findByEmailAndPassword(String email, String password);
}
