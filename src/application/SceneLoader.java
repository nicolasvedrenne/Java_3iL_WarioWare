package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {
	private Stage stage;
	public static final int SCENE_TITLE = 0;
	public static final int SCENE_GAME1 = 1;
	public static final int SCENE_GAME2 = 2;
	
	public SceneLoader(Stage stage) {
		this.stage = stage;
	}
	
	public void switchTo(int scene) throws IOException {
		switch (scene) {
		case SCENE_TITLE :
			stage.setScene(makeSceneTitle());
			break;
		case SCENE_GAME1 :
			stage.setScene(makeSceneGame1());
			break;
		case SCENE_GAME2 :
			stage.setScene(makeSceneGame2());
			break;
		}
	}

	private Scene makeSceneGame1() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("views/SceneGame1.fxml"));
		Scene scene = new Scene(root,1280,720);
		
		
		return scene;
	}

	private Scene makeSceneTitle() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("views/MainMenu.fxml"));
		Scene scene = new Scene(root,1280,720);
		return scene;
	}
	private Scene makeSceneGame2() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("views/SceneGame2.fxml"));
		Scene scene = new Scene(root,1280,720);
		
		return scene;
	}
}
