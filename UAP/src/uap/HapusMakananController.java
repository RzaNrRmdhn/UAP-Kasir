package uap;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HapusMakananController {

    MakananModel mkn = new MakananModel();

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtfldID;

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goOK(ActionEvent event) throws IOException {
        Makanan mkn1 = new Makanan(Integer.parseInt(txtfldID.getText()));
        mkn.deleteMakanan(mkn1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = (Parent) loader.load(); 
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
