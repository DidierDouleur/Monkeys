package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import model.IslandTest;
import model.MapTest2;
import model.MonkeyTest3;
import model.PirateTest3;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    IslandTest.class,
    MapTest2.class,
    MonkeyTest3.class,
    PirateTest3.class,
    
})
public class IntegTestSuite {

}
