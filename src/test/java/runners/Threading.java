package runners;

import org.junit.runner.JUnitCore;

import javafx.concurrent.Task;

@SuppressWarnings("restriction")
public class Threading extends Task<Long>{

	@Override
	protected Long call() throws Exception {
		JUnitCore.main(RunCukesTest.class.getCanonicalName());
		return null;
	}
	
}
