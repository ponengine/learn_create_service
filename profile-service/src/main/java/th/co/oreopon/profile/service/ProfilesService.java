package th.co.oreopon.profile.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import th.co.oreopon.profile.entity.Profiles;
import th.co.oreopon.profile.repository.ProfileRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@AllArgsConstructor
public class ProfilesService {

    private final ProfileRepository profileRepository;


    public ResponseEntity<Profiles> getProfilesById(String id) throws UserPrincipalNotFoundException {
        Profiles profiles=profileRepository.findByProfileId(id);
        if(null==profiles){
            throw new UserPrincipalNotFoundException("No profiles found");
        }
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    public ResponseEntity<String> updateProfilesById(String id,Profiles updateProfile) throws UserPrincipalNotFoundException {
        Profiles profiles=profileRepository.findByProfileId(id);
        if(null==profiles){
            return new ResponseEntity(profiles, HttpStatus.NOT_FOUND);
        }
        updateProfiles(updateProfile,profiles);
        profileRepository.save(profiles);
        return new ResponseEntity<>("Update success", HttpStatus.OK);
    }

    private void updateProfiles(Profiles updateProfile, Profiles profiles) {
        profiles.setFirstName(updateProfile.getFirstName());
        profiles.setLastName(updateProfile.getLastName());
        profiles.setJob(updateProfile.getJob());
    }
}