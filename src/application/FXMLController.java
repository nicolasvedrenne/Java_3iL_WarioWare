package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FXMLController {

	@FXML
	private Button dankButton;
	@FXML
	protected void playCancer(ActionEvent event) throws InterruptedException {
		File audioFile = new File("thomas_dank.mp3");
		Media audio = new Media(audioFile.toURI().toString());
		MediaPlayer audioPlayer = new MediaPlayer(audio);
		audioPlayer.play();
		while(train.getLayoutX()> 10) {
			train.setLayoutX(train.getLayoutX()-1);
		}
	}
	@FXML
	private ImageView train;
}
