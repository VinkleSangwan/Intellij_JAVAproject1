import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application {
    public static void main(String[]args){
launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
MenuBar menuBar = createMenu();
rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Convertor Tool");
        primaryStage.show();

    }
    private MenuBar createMenu(){
        Menu FileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        FileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
        quitMenuItem.setOnAction(event -> Platform.exit());
        Menu HelpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> aboutApp());
        HelpMenu.getItems().addAll(aboutApp);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(FileMenu, HelpMenu);
        return menuBar;
    }

    public static void aboutApp() {
Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
alertDialog.setTitle("My First Java Desktop App");
alertDialog.setHeaderText("Learning JavaFx");
alertDialog.setContentText("I am a beginner but soon i will be pro and start developing awesome games");
ButtonType yesBtn = new ButtonType("Yes");
ButtonType noBtn = new ButtonType("No");
alertDialog.getButtonTypes().setAll(ButtonType.YES,ButtonType.NO);
alertDialog.show();
    }
}
