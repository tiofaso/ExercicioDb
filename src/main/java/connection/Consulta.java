package connection;

import model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta { //Consulta dados na DB
    public void consultaDados() {

        String sql = "SELECT id_usuario, nome FROM usuarios";

        //Abrindo conexão
        Connection conexao = Conexao.getConnection();

        try{
            if(conexao != null) {
                Statement statement = conexao.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getLong("id_usuario") + ", nome: " +
                                        resultSet.getString("nome"));
                }

            }

        }catch (SQLException e) {
            System.out.println("Não foi possível listar os nomes. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }
}

