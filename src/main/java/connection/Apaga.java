package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Apaga{ //Apaga dados da DB
    public void apagaDados(int id){
        String sql = "DELETE FROM usuarios WHERE id_usuario ='" + id + "'";

        //Abrindo conexão
        Connection conexao = Conexao.getConnection();

        try{

            if(conexao != null) {
                Statement statement = conexao.createStatement();

                statement.executeUpdate(sql);

                System.out.println("Nome apagado com sucesso da base de dados!");
            }

        }catch (SQLException e) {
            System.out.println("Não foi possível apagar o nome da base de dados. Veja o motivo a seguir:");

            e.printStackTrace();
        }

    }

}
