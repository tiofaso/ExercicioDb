package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AtualizaConnection { //Atualiza dados da DB
    public void atualizaDados(int id, String nome) {
        String sql = "UPDATE usuarios SET nome = '" + nome + "' WHERE id_usuario = '" + id + "'";

        //Abrindo conexão
        Connection conexao = ConexaoConnection.getConnection();

        try{

            if(conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);

                System.out.println("Nome atualizado com sucesso na base de dados!");
            }

        }catch (SQLException e) {
            System.out.println("Não foi possível atualizar o nome na base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }


    }
}
