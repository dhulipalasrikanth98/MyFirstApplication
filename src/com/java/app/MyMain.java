package com.java.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String args[]){
		launch(args);

	}
	private void aboutApp(){
		// alert dialog box
		Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
		dialog.setTitle("My first Java Application");// title for my about tab when clicked
		dialog.setHeaderText("Java Fx");//sub heading of the tab
		dialog.setContentText(" this application belongs to to me all rights are reveserved");// text in the about
		ButtonType btn =new ButtonType("Yes");
		ButtonType nobtn = new ButtonType("No");
		dialog.getButtonTypes().setAll(btn,nobtn);
		Optional<ButtonType> clicked=dialog.showAndWait();// show and wait contain the named optional class
		if(clicked.isPresent() && clicked.get()==btn){// we will check two conditions if button is present or not and also the clciked button
			System.out.println("Yes button clicked");
		}
		if(clicked.isPresent() && clicked.get()==nobtn){//we will check two conditions if button is present or not and also the clciked button
			System.out.println("No");
		}
	}
	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox v = loader.load();// loads the verical box
		Separator s = new Separator();
		MenuBar menu = createMenu();//creates the menu
		v.getChildren().add(0,menu);//add the menu bar
		Scene scene = new Scene(v);//set the scence inside the stage
		primaryStage.setScene(scene);//seeting the scene in the stage
		primaryStage.setTitle("Hello World");//set the title for tbe scene
		primaryStage.show();//it will display the scene
		//primaryStage.setResizable(false);
	}
	public MenuBar createMenu(){
		Menu fileMenu = new Menu("File");//creates the menu
		MenuItem newFile = new MenuItem("New");//create the menu item
		//it will implement the action Listner
		newFile.setOnAction(event -> System.out.print("new file clicked!"));
		SeparatorMenuItem seperate = new SeparatorMenuItem();//seperate the menu items in the menu
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(event -> {
			Platform.exit();//to exit the event
			System.exit(0);
		});
		fileMenu.getItems().addAll(newFile,seperate,exit);//combining the menu items into the menu in this fileName adds the new file and the exit separated by  a line
		Menu helpMenu = new Menu("Help");
		MenuItem about = new MenuItem("about");
		about.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(about);
		MenuBar menu = new MenuBar();
		menu.getMenus().addAll(fileMenu,helpMenu);//combine all the menu in this example we combined the file and the help menu into the menu bar
		return menu;
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
