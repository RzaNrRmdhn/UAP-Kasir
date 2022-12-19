package uap;

import static db.DBHelper.getConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class KategoriController implements Initializable{

    @FXML
    private TableView<Kategori> viewTable;

    @FXML
    private TableColumn<Kategori, String> ColomnNama;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showKategori();
    }


    @FXML
    void goHapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hapusKategori.fxml"));
        Parent root = (Parent) loader.load(); 
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) loader.load(); 
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahKategori.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Kategori> getListKategori(){ 
        ObservableList<Kategori> listKategori = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM kategori;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Kategori ktg1 = new Kategori(rs.getString("kategori"));
                listKategori.add(ktg1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listKategori;
    }

    public void showKategori(){
        ObservableList<Kategori> list = getListKategori();
        ColomnNama.setCellValueFactory(new PropertyValueFactory<Kategori, String>("nama_kategori"));

        viewTable.setItems(list);
    }

}
