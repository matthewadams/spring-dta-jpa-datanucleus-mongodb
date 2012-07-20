package app.service.profile.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import app.domain.Profile;
import app.domain.repo.ProfileRepository;
import app.service.profile.ProfileDto;
import app.service.profile.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	protected ProfileRepository repo;

	public ProfileServiceImpl() {
	}

	public ProfileServiceImpl(ProfileRepository repo) {
		setProfileRepository(repo);
	}

	public void setProfileRepository(ProfileRepository repo) {
		Assert.notNull(repo);
		this.repo = repo;
	}

	@Override
	public String save(ProfileDto dto) {
		// TODO: aspectize this
		if (dto == null) {
			throw new IllegalArgumentException("no dto given");
		}

		Profile entity;
		if (dto.getId() == null) {
			entity = new Profile();
		} else {
			entity = repo.findOne(dto.getId());
		}

		// TODO: use Dozer here; configure it to set values of basic types only
		// if they differ
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());

		repo.save(entity);
		repo.flush();

		return entity.getId();
	}
}
