package testNgListenerConceptTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener {

	// INTERFACE METHODS
	public void onTestFailure(ITestResult reult) {
		System.out.println("failed Test");
		failed(reult.getMethod().getMethodName());

	}

	public void onTestStart(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	public void onTestSuccess(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 */
	public void onStart(ITestContext context) {
		// not implemented
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 */
	public void onFinish(ITestContext context) {
		// not implemented
	}
}
