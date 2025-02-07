package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplimentation implements IRetryAnalyzer {
	int count=1;
	int maxcount=4;
	@Override
	public boolean retry(ITestResult result) {
		while(count<=maxcount) {
			count++;
			return true;
		}
		return false;
	}

}
//this will applyed in method lvl only(in@test line)