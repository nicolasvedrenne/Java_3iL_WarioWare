package application;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static SceneLoader sceneLoader;
	@Override
	public void start(Stage primaryStage) {
		
		try {
			sceneLoader = new SceneLoader(primaryStage);
			sceneLoader.switchTo(SceneLoader.SCENE_TITLE);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			launch(args);
	}
}
