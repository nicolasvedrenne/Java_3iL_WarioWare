package application;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

public class FXMLController {
	
	private String mouseClic;
	private int randomPercent = 0;
	private KeyCode qteLoading = KeyCode.UP;
	@FXML
	private ImageView arrowUP;
	@FXML
	private ImageView arrowDOWN;
	@FXML
	private ImageView arrowLEFT;
	@FXML
	private ImageView arrowRIGHT;
	@FXML
	private Label headText;
	@FXML
	private ImageView train;
	@FXML
	private ImageView hat;
	@FXML
	private Rectangle headHitbox;
	@FXML
	private Button dankButton;
	@FXML
	private Button toGame1Button;
	@FXML
	private Rectangle greenLoading;
	@FXML
	protected void increaseLoading(KeyEvent event) {
		if(event.getCode()==qteLoading && greenLoading.getWidth()<=760) {
			greenLoading.setWidth(greenLoading.getWidth() + 20);
			System.out.println(greenLoading.getWidth());
			randomPercent = ThreadLocalRandom.current().nextInt(0, 100 + 1);
			if(randomPercent > 0 && randomPercent <=35) {
				randomPercent = ThreadLocalRandom.current().nextInt(0, 3 + 1);
				switch (randomPercent) {
				case 0 :
					qteLoading = KeyCode.UP;
					arrowDOWN.setOpacity(0);
					arrowUP.setOpacity(1);
					arrowLEFT.setOpacity(0);
					arrowRIGHT.setOpacity(0);
					break;
				case 1 :
					qteLoading = KeyCode.DOWN;
					arrowDOWN.setOpacity(1);
					arrowUP.setOpacity(0);
					arrowLEFT.setOpacity(0);
					arrowRIGHT.setOpacity(0);
					break;
				case 2 :
					qteLoading = KeyCode.LEFT;
					arrowDOWN.setOpacity(0);
					arrowUP.setOpacity(0);
					arrowLEFT.setOpacity(1);
					arrowRIGHT.setOpacity(0);
					break;
				case 3 :
					qteLoading = KeyCode.RIGHT;
					arrowDOWN.setOpacity(0);
					arrowUP.setOpacity(0);
					arrowLEFT.setOpacity(0);
					arrowRIGHT.setOpacity(1);
					break;
				}
			}
		}
		else if(event.getCode()!= qteLoading && greenLoading.getWidth()>=20 && greenLoading.getWidth()<=780) {
			greenLoading.setWidth(greenLoading.getWidth() - 10);
		}
		else if (greenLoading.getWidth()>760 && greenLoading.getWidth()<=800) {
			try {
				Main.sceneLoader.switchTo(SceneLoader.SCENE_TITLE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@FXML
	protected void playCancer() throws InterruptedException {
		File audioFile = new File("thomas_dank.mp3");
		Media audio = new Media(audioFile.toURI().toString());
		MediaPlayer audioPlayer = new MediaPlayer(audio);
		audioPlayer.play();
		while(train.getLayoutX()> 10) {
			train.setLayoutX(train.getLayoutX()-1);
		}
	}
	@FXML
	protected void toGame1(){
		try {
			Main.sceneLoader.switchTo(SceneLoader.SCENE_GAME1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void hatClicked() {
		this.mouseClic = "hat";
		this.headText.setOpacity(1);
		this.headText.setMouseTransparent(true);
	}
	@FXML
	protected void headClicked(){
		if (this.mouseClic.equals("hat")) {
			this.mouseClic = "head";
			this.headText.setOpacity(0);
			this.headText.setMouseTransparent(false);
			hat.setLayoutX(750);
			hat.setLayoutY(0);
			try {
				Main.sceneLoader.switchTo(SceneLoader.SCENE_GAME2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
