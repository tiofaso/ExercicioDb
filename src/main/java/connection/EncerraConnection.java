package connection;

import java.sql.Connection;
public class EncerraConnection {
    public void fechaDb(){
        Connection conexao = ConexaoConnection.closeConnection();
    }
}
