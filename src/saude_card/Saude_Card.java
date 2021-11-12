/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saude_card;

import java.sql.SQLException;
import Interface.ILogin;
import infoDB.Commands;
import Interface.IVaccineCard;

/**
 *
 * @author Albatrox
 */
public class Saude_Card {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        ILogin StartAPP = new ILogin();
        
        StartAPP.setVisible(true);
        StartAPP.setTitle("Cartão de Vacinação - Login");
        
    }
    
}
