package th.co.oreopon.authen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.oreopon.authen.entity.ERole;
import th.co.oreopon.authen.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
