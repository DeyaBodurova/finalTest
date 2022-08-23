package ZooApp;

import ZooApp.core.Engine;
import ZooApp.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}