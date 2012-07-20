package app.domain.test.unit;

import java.util.UUID;

public abstract class AbstractUnitTest {

	static public String uuid() {
		return UUID.randomUUID().toString();
	}
}
