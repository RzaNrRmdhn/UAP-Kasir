package uap;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static db.DBHelper.getConnection;

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

public class MakananController implements Initializable {

    @FXML
    private TableColumn<Makanan, Integer> ColomnDaya;

    @FXML
    private TableColumn<Makanan, Double> ColomnDiskon;

    @FXML
    private TableColumn<Makanan, Integer> ColomnId;

    @FXML
    private TableColumn<Makanan, Integer> ColomnJumlah;

    @FXML
    private TableColumn<Makanan, String> ColomnNama;

    @FXML
    private TableColumn<Makanan, Double> ColomnHarga;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnKembali;

    @FXML
    private Button btnTambah;

    @FXML
    private TableView<Makanan> viewTable;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showMakanan();
    }

    @FXML
    void goHapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hapusMakanan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnHapus.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goKembali(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnKembali.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void goTambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tambahMakanan.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public ObservableList<Makanan> getListMakanan(){
        ObservableList<Makanan> listMakanan = FXCollections.observableArrayList();
        Connection CONN = getConnection();
        String query = "SELECT * FROM makanan;";
        Statement st;
        ResultSet rs;

        try{
            st = CONN.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Makanan mkn = new Makanan(rs.getString("Nama"), rs.getDouble("Harga"),
                                            rs.getDouble("Diskon"), rs.getInt("Jumlah"),
                                            rs.getInt("Id"), rs.getInt("Daya_Tahan"));
                listMakanan.add(mkn);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listMakanan;
    }

    public void showMakanan(){
        ObservableList<Makanan> list = getListMakanan();
        ColomnNama.setCellValueFactory(new PropertyValueFactory<Makanan, String>("nama_produk"));
        ColomnHarga.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("harga"));
        ColomnDiskon.setCellValueFactory(new PropertyValueFactory<Makanan, Double>("diskon"));
        ColomnJumlah.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("jumlah"));
        ColomnId.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("id"));
        ColomnDaya.setCellValueFactory(new PropertyValueFactory<Makanan, Integer>("daya_tahan"));

        viewTable.setItems(list);
    }

}
