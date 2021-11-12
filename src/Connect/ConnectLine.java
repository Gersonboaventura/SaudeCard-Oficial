/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Albatrox
 */
public class ConnectLine {
    private Connection conecta;
    private String driver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String servidorDB= "saudecard.database.windows.net";
    private String servPORTA= "1433";
    private String dataBASE= "SaudeCARD_DB";
    private String usuARIO= "albatroxdev";
    private String seNHA= "Lapsparks02@";
    
    private String liNK= "jdbc:sqlserver://" + servidorDB+ ":"+ servPORTA+ ";databaseName=" + dataBASE;
    
    public Connection obterLink() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conecta = DriverManager.getConnection(liNK, usuARIO, seNHA);
            System.out.println("Conectado com sucesso!");
            return conecta;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
    }
}   