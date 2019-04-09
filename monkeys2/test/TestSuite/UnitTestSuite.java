package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import model.MapTest;
import model.MonkeyUnitTest;
import model.PirateUnitTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  PirateUnitTest.class,
  MonkeyUnitTest.class,
  MapTest.class,
  
})
public class UnitTestSuite {


}
