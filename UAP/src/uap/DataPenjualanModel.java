package uap;

import db.DBHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataPenjualanModel {
    private final Connection CONN;

    public DataPenjualanModel() {
        this.CONN = DBHelper.getConnection();
    }

    public void addPenjualan(Penjualan pjl){
        String insert = "INSERT INTO datapenjualan VALUES ('" + pjl.getNamaProduk() + 
                        "', '" + pjl.getStok() + "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Data berhasil dimasukkan");
            }
            else{
                System.out.println("Data gagal dimasukkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataPenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dimasukkan");
        }
    }

    public void deletePenjualan(Penjualan pjl){
        String delete = "DELETE FROM datapenjualan WHERE Nama = '" + pjl.getNamaProduk() + "';";
        try {
            if(CONN.createStatement().executeUpdate(delete) > 0){
                System.out.println("Data berhasil diHapus");
            }
            else{
                System.out.println("Data gagal dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataPenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data gagal dihapus");
        }
    }   
}
