package th.co.oreopon.profile.repository;

import org.springframework.data.repository.CrudRepository;
import th.co.oreopon.profile.entity.Profiles;

public interface ProfileRepository extends CrudRepository<Profiles,String> {

    Profiles findByProfileId(String id);
}
