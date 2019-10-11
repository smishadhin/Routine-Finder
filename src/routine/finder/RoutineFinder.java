/*
 * This code is written by Muhiminul Islam Shadhin (website: shadhin.slasstec.com) and he is copyright owner
 * Only  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) has the authority to change the code.
 * If you are viewing or editing the code without the permission of  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) then its a crime and you
are breaking the law of copyright.
 */
package routine.finder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Muhiminul Islam Shadhin <smi.shadhin at gmail.com>
 */
public class RoutineFinder extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("icon-routine.png"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.getIcons().add(icon);
        Scene scene = new Scene(root);
        stage.setTitle("Routine Finder");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        FXMLDocumentController fxmldc = new FXMLDocumentController();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                // consume event
                event.consume();

                // show close dialog
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Close Confirmation");
                alert.setHeaderText("Do you really want to quit?");
                alert.initOwner(stage);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        launch(args);

    }

}
