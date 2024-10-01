/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.*;
import javax.swing.JOptionPane;


public class conexaodao {

public static Connection conector() {
java.sql.Connection conexao = null;
    
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/bdprojetoaula";
String user = "root";
String password = "root";

try {
    Class.forName(driver);
    conexao = DriverManager.getConnection(url, user, password);  
    
    return conexao;
}catch (Exception e){
    JOptionPane.showMessageDialog(null,"conexão falhou:" + e.getMessage());
  return null;
  }
 }
}