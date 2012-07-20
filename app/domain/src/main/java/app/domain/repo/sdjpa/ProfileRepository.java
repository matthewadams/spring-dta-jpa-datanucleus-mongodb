package app.domain.repo.sdjpa;

import app.domain.Profile;

public interface ProfileRepository extends
		JpaSpecificationQueryDslRepository<Profile, String> {
}
