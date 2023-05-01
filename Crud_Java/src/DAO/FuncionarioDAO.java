package DAO;

import DTO.FuncionarioDTO;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) {

        String sql = "insert into funcionario(nome_funcionario, cpf_funcionario, endereco_funcionario, email_funcionario) values(?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_funcionario());
            pstm.setString(2, objfuncionariodto.getCpf_funcionario());
            pstm.setString(3, objfuncionariodto.getEndereco_funcionario());
            pstm.setString(4, objfuncionariodto.getEmail_funcionario());

            pstm.execute();

            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO" + erro);

        }

    }

    public ArrayList<FuncionarioDTO> PesquisarFuncionario() {

        String sql = "Select * from funcionario";
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
                objfuncionariodto.setId_funcionario(rs.getInt("id_funcionario"));
                objfuncionariodto.setNome_funcionario(rs.getString("nome_funcionario"));
                objfuncionariodto.setCpf_funcionario(rs.getNString("cpf_funcionario"));
                objfuncionariodto.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                objfuncionariodto.setEmail_funcionario(rs.getString("email_funcionario"));

                lista.add(objfuncionariodto);

            }

        } catch (SQLException erro) {
            JOptionPane.showInternalConfirmDialog(null, "FuncionarioDAO Pesquisar" + erro);

        }
        return lista;

    }

    public void alterarFuncionario(FuncionarioDTO obFuncionarioDTO) {

        String sql = "update funcionario set nome_funcionario = ?, cpf_funcionario = ?, endereco_funcionario = ?,email_funcionario = ? where id_funcionario = ?";

         conn = new ConexaoDAO().conectaBD();
        
        
        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obFuncionarioDTO.getNome_funcionario());
            pstm.setString(2, obFuncionarioDTO.getCpf_funcionario());
            pstm.setString(3, obFuncionarioDTO.getEndereco_funcionario());
            pstm.setString(4, obFuncionarioDTO.getEmail_funcionario());
            pstm.setInt(5, obFuncionarioDTO.getId_funcionario());

            pstm.execute();

            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO Alterar" + erro);

        }

    }
    
    
    
    
     public void excluirFuncionario(FuncionarioDTO obFuncionarioDTO) {

        String sql = "  DELETE FROM funcionario WHERE id_funcionario =  ?;";

        
        
        
        
        
        conn = new ConexaoDAO().conectaBD();
        
        
        try {

            pstm = conn.prepareStatement(sql);
           
            pstm.setInt(1, obFuncionarioDTO.getId_funcionario());

            pstm.execute();

            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir" + erro);

        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
