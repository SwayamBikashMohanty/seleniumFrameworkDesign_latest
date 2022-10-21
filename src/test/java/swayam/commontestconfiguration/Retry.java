package swayam.commontestconfiguration;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/*Fleaky or other reasons if test cases failed then we use
 * IRetryAnalyzer=used to re-run the fail test cases 
 */

public class Retry implements IRetryAnalyzer{

	int count=0;
	int maxtry=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxtry) {
			count++;
			return true;
		}
		return false;
	}

}
