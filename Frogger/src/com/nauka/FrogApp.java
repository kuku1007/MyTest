package com.nauka;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FrogApp extends Application {

	Pane root;
	Node frog;
	List<Node> cars = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	Node initFrog() {
		Rectangle rect = new Rectangle(38, 38, Color.GREEN);
		rect.setTranslateY(600 - 39);
		return rect;
	}

	Node spawnCar() {
		Rectangle rect = new Rectangle(38, 38, Color.RED);
		rect.setTranslateY(Math.random() * 14 * 40);
		root.getChildren().add(rect);
		return rect;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Pane();
		frog = initFrog();
		root.getChildren().add(frog);
		spawnCar();
		Scene scene = new Scene(root, 800, 600);
		scene.setOnKeyPressed(event -> {
			switch (event.getCode()) {
			case W:
				frog.setTranslateY(frog.getTranslateY() - 40);
				break;
			case S:
				frog.setTranslateY(frog.getTranslateY() + 40);
				break;
			case A:
				frog.setTranslateX(frog.getTranslateX() - 40);
				break;
			case D:
				frog.setTranslateX(frog.getTranslateX() + 40);
				break;					
			default:
				break;
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
