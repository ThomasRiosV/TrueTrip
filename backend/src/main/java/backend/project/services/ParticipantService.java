package backend.project.services;

import backend.project.entities.Authority;
import backend.project.entities.User;

import java.util.List;

public interface ParticipantService {

    public boolean joinTravelPost(Long travelPostId, String username);
    public boolean cancelParticipation(Long travelPostId, String username);
    public List<User> getParticipantsForTravelPost(Long travelPostId);

    interface AuthorityService {
        public Authority save(Authority authority);
    }
}
