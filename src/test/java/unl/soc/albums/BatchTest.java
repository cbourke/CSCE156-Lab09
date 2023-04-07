package unl.soc.albums;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * This is a batch test file used by grading scripts to generate a full roster
 * grade report.
 * 
 * @author cbourke
 *
 */
public class BatchTest {

	SummaryGeneratingListener listener = new SummaryGeneratingListener();

	public void runAll() {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass("unl.soc.albums.AlbumTests")).build();
		Launcher launcher = LauncherFactory.create();
		@SuppressWarnings("unused")
		TestPlan testPlan = launcher.discover(request);
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}

	public static void main(String[] args) {

		// suppress standard output while tests are run
		PrintStream original = new PrintStream(System.out);
		PrintStream nps;
		try {
			nps = new PrintStream(new FileOutputStream("/dev/null"));
			System.setOut(nps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BatchTest bt = new BatchTest();

		bt.runAll();

		// restore standard output for report
		System.setOut(original);

		TestExecutionSummary summary = bt.listener.getSummary();
		// summary.printTo(new PrintWriter(System.out));

		int labPoints = 20;
		long numTests = summary.getTestsFoundCount();
		long numFail = summary.getTestsFailedCount();
		long numPass = summary.getTestsSucceededCount();

		// prints total number of points, number of pass/fail
		// and total tests in csv format
		System.out.printf("%d,%d,%d,%d", numFail == 0 ? labPoints : 0, numPass, numFail, numTests);

	}

}
