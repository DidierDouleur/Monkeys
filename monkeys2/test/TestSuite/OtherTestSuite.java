package TestSuite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import model.CellTest;
import model.GameMasterTest;
import model.IslandTest;
import model.PirateTest2;
import model.RhumGroupTest;
import model.StrategyHuntingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CellTest.class, GameMasterTest.class, IslandTest.class, Test.class,
        StrategyHuntingTest.class, PirateTest2.class, RhumGroupTest.class, })

/**
 * Sont présent dans cette suite de test tous les autres tests ayant été rédigés, certains sont
 * incomplet, d'autres juste des test personnel pour vérifier certain fonctionnement mais de manière
 * non formel
 * 
 * @author bij
 *
 */
public class OtherTestSuite {

}
