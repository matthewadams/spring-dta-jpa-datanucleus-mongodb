package app.domain.repo;

import app.domain.Profile;

public interface ProfileRepository extends
		CrudJpaRepository<Profile, String> {
}
