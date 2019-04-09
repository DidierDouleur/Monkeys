package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import model.MonkeyParamTest2;
import model.PirateParamTest;
import model.StartegyErraticParamTest;
import model.StrategyErratic;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  PirateParamTest.class,
  MonkeyParamTest2.class,
  StartegyErraticParamTest.class,
})
public class ParamTestSuite {

}
