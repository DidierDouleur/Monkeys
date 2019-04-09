package model;

import static org.junit.Assert.*;

public class Test {
    

    @org.junit.Test
    public void test() {

        GameMaster ms = GameMaster.getInstance();
        Config config = new Config();
        Island island = new Island();
        
        ms.setConfig(config);

        Map map = new Map(2, 2);

        map.createMap("111111111");
        ms.setIsland(island);
        island.setMap(map);

        Monkey monkey = new Monkey(0, 0, EMonkeyType.HUNTER);
        Pirate pirate = new Pirate(2, 2, 1,20);
        
        assertEquals(pirate.canAccess(null),false);

        island.getListPirate().add(pirate);

        map.printMapElements();
        
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            monkey.askMove();
            System.out.println();
            map.printMapElements();
            
            assertEquals(pirate.getState(),EPirateState.DEAD);

    }
    
   

}
