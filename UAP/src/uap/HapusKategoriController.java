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

public class HapusKategoriController {

    KategoriModel ktg = new KategoriModel();

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtfldNamaKategori;

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goOK(ActionEvent event) throws IOException {
        Kategori ktg1 = new Kategori(txtfldNamaKategori.getText());
        ktg.deleteKategori(ktg1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = (Parent) loader.load(); 
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
