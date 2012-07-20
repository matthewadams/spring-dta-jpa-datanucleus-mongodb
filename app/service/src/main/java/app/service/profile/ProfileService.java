package app.service.profile;

/**
 * Business service facade for profile-related behavior. Only data transfer
 * objects (DTOs) cross this boundary.
 */
public interface ProfileService {

	/**
	 * Saves or updates the given profile info. If the id field is null, it will
	 * be persisted anew, else updated.
	 * 
	 * @param dto
	 * @return the id of the underlying object
	 */
	String save(ProfileDto dto);
}
