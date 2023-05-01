package DAO;

import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "Select * from usuario where nome_usuario = ? and senha_usuario = ?";

            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setString(1, objUsuarioDTO.getNome_usuario());
            psmt.setString(2, objUsuarioDTO.getSenha_usuario());

            ResultSet rs = psmt.executeQuery();
            return rs;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            return null;
        }

    }

}

/* tinha uma chave de feichamento aqui eu tirei se der um possivel erro olhar aui !!!!*/
