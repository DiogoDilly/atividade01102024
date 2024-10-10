/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.DTO.usuariodto;
import java.sql.*;
import javax.swing.JOptionPane;

public class usuariodao {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void inserirusuario(usuariodto objusuariodto){
        String sql = "insert into tb_usuario(id_usuario,login, senha) values (?, ?, ?)";
    conexao = new conexaodao().conector();
    
    
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objusuariodto.getId_usuario());
            pst.setString(2, objusuariodto.getLoginusuario());
            pst.setString(3, objusuariodto.getSenhausuario());
            
            pst.execute();
            pst.close();
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
            if(e.getMessage().contains("'tb_usuario.PRIMARY'")){
                JOptionPane.showMessageDialog(null, "ID ja em uso.");
            } else if (e.getMessage().contains("'tb_usuario.login_UNIQUE'")){
                JOptionPane.showMessageDialog(null, "login ja em uso.");
            } else{
                JOptionPane.showMessageDialog(null, "metodo addUsu: "+e.getMessage());
            }
        }
    }
   public void apagar(usuariodto objusuariodto){
       String sql ="delete from tb_usuario where id_usuario = ?";
   conexao = conexaodao.conector();
       try {
           pst = conexao.prepareStatement(sql);
           pst.setInt(1, objusuariodto.getId_usuario());
       int add = pst.executeUpdate();
     
       if (add > 0){
           conexao.close();
           JOptionPane.showMessageDialog(null,"coisa");
           apagarcampos();
       }
       } catch (Exception e) {
       
       
       
       }
   
   
   
   
   } 
    
    
}
