/*
 * This code is written by Muhiminul Islam Shadhin (website: shadhin.slasstec.com) and he is copyright owner
 * Only  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) has the authority to change the code.
 * If you are viewing or editing the code without the permission of  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) then its a crime and you
are breaking the law of copyright.
 */
package routine.finder;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Muhiminul Islam Shadhin <smi.shadhin at gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    private File file;

    @FXML
    private Label studentFileStatusLable;
    @FXML
    public Label status;
    @FXML
    private Button genertButton;
    @FXML
    private Button Browsebutton;
    @FXML
    private ProgressBar progressbar;

    public boolean close=false;
    @FXML
    public File studentFileChooser(ActionEvent event) {
        Stage fileStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Excel file.xlsx", "*.xlsx")
        );
        file = fileChooser.showOpenDialog(fileStage);
        if (file != null) {
            studentFileStatusLable.setText("file choosed");
            Browsebutton.setDisable(true);
            genertButton.setDisable(false);
        }
        return file;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status.setText("");
        genertButton.setDisable(true);
        // progressbar.setProgress(.1f);
    }

    @FXML
    private void generate(ActionEvent event) throws Exception, SQLException, SQLException {
        close=true;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Uploading Routine will start soon.\nIt may take 5-10 minutes for uploading process.\nPress OK or close this window to start uploadin.\nAnd Please wait for compleating confirmation.");
        status.setText("Please Wait.....\n" + "Routine is Uploading...\nIt may take 5-10 minutes for uploading process");
        genertButton.setDisable(true);
        progressbar.setProgress(.3f);
        alert.showAndWait();
        AllCourses courses = new AllCourses();
        try {
            courses.FilterCourses(file);
            progressbar.setProgress(.5f);
        } catch (SQLException ex) {
            //  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        truncate();
        progressbar.setProgress(.7f);
        retrivedata();
        progressbar.setProgress(1.0f);
        status.setText(".......COMPLETE......");
    }

    void retrivedata() throws ClassNotFoundException, SQLException, Exception {
        //status();
        //System.out.println("Starting\n\n\n");
        Connection c = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:course.db");
        c.setAutoCommit(false);
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT DISTINCT CourseCode FROM courselist");
        while (rs.next()) {
            String course = rs.getString("CourseCode");
            Saturday satur = new Saturday();
            satur.saturday(course, file);
            Sunday sun = new Sunday();
            sun.sunday(course, file);
            Monday mon = new Monday();
            mon.monday(course, file);
            Tuesday tues = new Tuesday();
            tues.tuesday(course, file);
            Wednessday wed = new Wednessday();
            wed.wednessday(course, file);
            Thursday thurs = new Thursday();
            thurs.thursday(course, file);
        }
        rs.close();
        stmt.close();
        c.close();
    }

    private void truncate() {
        Biodata trk = new Biodata();
        trk.truncateBiodata();
    }

}
