package model;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class GameMasterTest {

    private GameMaster gameMaster;

    @Before
    public void setUp() throws Exception {
        this.gameMaster = GameMaster.getInstance();
        this.gameMaster.setConfig(new Config());
        this.gameMaster.setIsland(new Island());
    }

    @Test
    public void testSingleton() throws Exception {
        assertEquals(this.gameMaster, GameMaster.getInstance());
    }

    @Test
    public void testIsland() throws Exception {
        Island island = new Island();
        this.gameMaster.setIsland(island);
        assertEquals(island, GameMaster.getInstance().getIsland());
    }

    @Test
    public void testMonkeyGroup() throws Exception {
        MonkeyGroup monkeyGroup = new MonkeyGroup();
        this.gameMaster.getIsland().setMonkeyGroup(monkeyGroup);
        assertEquals(this.gameMaster.getIsland().getMonkeyGroup(), monkeyGroup);
    }

    @Test
    public void testConfig() throws Exception {
        Config config = new Config();
        this.gameMaster.setConfig(config);
        assertEquals(gameMaster.getConfig(), config);

    }

    @Test
    public void test() throws Exception {
        this.gameMaster.initGame();
        TimeUnit.SECONDS.sleep(7);
        this.gameMaster.setRunning(false);
    }

}
