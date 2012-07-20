package app.domain.repo.impl;

import javax.persistence.EntityManager;

import app.domain.Profile;
import app.domain.repo.ProfileRepository;

public class ProfileRepositoryImpl extends
		CrudJpaRepositoryImpl<Profile, String> implements ProfileRepository {

	public ProfileRepositoryImpl() {
		super(Profile.class);
	}

	public ProfileRepositoryImpl(EntityManager em) {
		super(Profile.class, em);
	}
}
