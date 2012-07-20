package app.domain.test.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import app.domain.Profile;

public class ProfileUnitTest extends AbstractUnitTest {

	// not much here, really just a placeholder to demonstrate that this is
	// where unit tests go

	@Test
	public void testProfile() {
		Profile p = new Profile();

		String first = uuid();
		String last = uuid();

		p.setFirstName(first);
		p.setLastName(last);

		assertThat(p.getFirstName(), equalTo(first));
		assertThat(p.getLastName(), equalTo(last));
	}
}
