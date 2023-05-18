package avenida.avenida.Repositorios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import avenida.avenida.Modelo.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByuserName(String userName);
    Optional<User> findById(Long userId);
}
