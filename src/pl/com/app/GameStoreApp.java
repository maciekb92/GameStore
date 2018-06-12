package pl.com.app;

public class GameStoreApp {

    public static void main(String[] args) {
        final String appName = "Game Store v1.0";
        System.out.println(appName);

        GameStoreControl gameStoreControl = new GameStoreControl();
        gameStoreControl.ControlLoop();
    }
}
