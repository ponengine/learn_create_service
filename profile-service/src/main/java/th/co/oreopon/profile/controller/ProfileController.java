package th.co.oreopon.profile.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.oreopon.profile.entity.Profiles;
import th.co.oreopon.profile.service.ProfilesService;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
public class ProfileController {

    private final ProfilesService profilesService;

    @GetMapping("/getProfile/{id}")
    public ResponseEntity<Profiles> getProfiles(@PathVariable String profileId) throws UserPrincipalNotFoundException {
    return profilesService.getProfilesById(profileId);
    }

    @GetMapping("/updateProfile/{id}")
    public ResponseEntity<String> updateProfiles(@PathVariable String profileId, @RequestBody Profiles profiles) throws UserPrincipalNotFoundException {
        return profilesService.updateProfilesById(profileId,profiles);
    }

}
