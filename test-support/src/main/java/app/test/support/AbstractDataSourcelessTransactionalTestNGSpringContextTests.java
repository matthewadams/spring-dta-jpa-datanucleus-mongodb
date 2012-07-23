package app.test.support;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Same as {@link AbstractTransactionalTestNGSpringContextTests}, except doesn't
 * require a {@link DataSource}.
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public abstract class AbstractDataSourcelessTransactionalTestNGSpringContextTests
		extends AbstractTestNGSpringContextTests {
}
