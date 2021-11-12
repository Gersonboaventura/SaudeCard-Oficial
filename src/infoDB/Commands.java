/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoDB;

import Connect.ConnectLine;
import notif.Nload;
import Interface.IVaccineCard;
        
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author Albatrox
 */
public class Commands {
    private Connection checkCONN;
    
    public Commands() {
        ConnectLine connCHECK = new ConnectLine();
        checkCONN = connCHECK.obterLink();
        
    }
    
    public void checkUSER (int cpf, int nasc) throws SQLException {
        Statement sTmT = checkCONN.createStatement();
        ResultSet rS = sTmT.executeQuery("select cpf, nascimento from usuarios");
        
        while (rS.next()) {
            Nload userCodeOK = new Nload();
            if (rS.getInt("cpf") == cpf && rS.getInt("nascimento") == nasc) {                
                userCodeOK.autentic(1);
            } else {
                userCodeOK.autentic(0);
            }

        }
    }
    
    public void novoUser(String nome, String n_mae, String n_pai, String telefone, String end_id, String cpf, String nascimento) throws SQLException {
        Statement stmt = checkCONN.createStatement();
        String SQL = "INSERT usuarios (nome, n_mae, n_pai, telefone, end_id, cpf, nascimento) VALUES('" + nome + "','" + n_mae + "','" + n_pai + "'," + telefone + "," + end_id + "," + cpf + "," + nascimento + ")";        
        stmt.executeUpdate(SQL);
        }
    
    public void novoAddr(String rua, int num, String bairro, String cid, int uf) throws SQLException {
        Statement stmt = checkCONN.createStatement();
        
        if (uf == 0) {
                 String UF = "AC";
             } else if (uf == 1) {
                 String UF = "AL";
             } else if (uf == 2) {
                 String UF = "AP";
             } else if (uf == 3) {
                 String UF = "AM";
             } else if (uf == 4) {
                 String UF = "BA";
             } else if (uf == 5) {
                 String UF = "CE";
             } else if (uf == 6) {
                 String UF = "DF";
             } else if (uf == 7) {
                 String UF = "ES";
             } else if (uf == 8) {
                 String UF = "GO";
             } else if (uf == 9) {
                 String UF = "MA";
             } else if (uf == 10) {
                 String UF = "MT";
             } else if (uf == 11) {
                 String UF = "MS";
             } else if (uf == 12) {
                String UF = "MG"; 
             } else if (uf == 13) {
                String UF = "PA"; 
             } else if (uf == 14) {
                String UF = "PB"; 
             } else if (uf == 15) {
                String UF = "PR"; 
             } else if (uf == 16) {
                String UF = "PE"; 
             } else if (uf == 17) {
               String UF = "PI";  
             } else if (uf == 18) {
                String UF = "RJ"; 
             } else if (uf == 19) {
                String UF = "RN"; 
             } else if (uf == 20) {
                String UF = "RS"; 
             } else if (uf == 21) {
                String UF = "RO"; 
             } else if (uf == 22) {
                String UF = "RR";
             } else if (uf == 23) {
                String UF = "SC";
             } else if (uf == 24) {
                String UF = "SP"; 
             } else if (uf == 25) {
                String UF = "SE"; 
             } else if (uf == 26) {
                String UF = "TO";
                
        String SQL = "INSERT enderecos (rua, num, bairro, cidade, estado) VALUES('" + rua + "','" + num + "','" + bairro + "','" + cid + "','" +  UF + "')";        
        stmt.executeUpdate(SQL);
        }
    }
    
    public void getVaccine (int vacID) throws SQLException {
        
        Statement sTmT = checkCONN.createStatement();
        ResultSet rsT = sTmT.executeQuery("select * from vacinas");
        while (rsT.next()) {
            if (rsT.getInt("vac_id") == vacID) {
                System.out.println(rsT.getString("nome"));
                
                //gSinfo.showInfo.add("Vacina: " + rsT.getString("nome"));
            }
        }
    }
}
