import connection.*;
import model.UsuarioModel;
import tools.LeitorTecladoIntTools;
import tools.LeitorTecladoStringTools;
import tools.MenuTools;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        //Instanciando usuário
        UsuarioModel usuarioModel = new UsuarioModel();

        MenuTools menuTools = new MenuTools();
        menuTools.mostraMenu();

        //Instanciando teclados
        LeitorTecladoIntTools tecladoInt = new LeitorTecladoIntTools();
        LeitorTecladoStringTools tecladoString = new LeitorTecladoStringTools();

        //Instanciando variáveis
        int id;
        String nome;
        int opcao;

        //Lendo teclado do menu
        opcao = tecladoInt.teclado();

        //Instanciando a exibição de nomes
        ConsultaConnection listaNomes = new ConsultaConnection();

        //Setando opção para sair do programa
        int sair = 0;

        while (sair == 0){

            //Executando as opções do menu
            switch (opcao) {
                case 1:
                    System.out.println("> INSERIR NOME");
                    System.out.println("Digite um nome:");

                    nome = tecladoString.teclado();

                    usuarioModel.setNome(nome);

                    InsereConnection novoNome = new InsereConnection();
                    novoNome.insereDados(usuarioModel.getNome());

                    System.out.println("\nInformações atuais da base de dados:");
                    listaNomes.consultaDados();

                    //-----
                    System.out.println("\n----");
                    System.out.println("Deseja sair? (0 - não | 1 - sim)");
                    sair = tecladoInt.teclado();

                    opcao = 0; //para abrir o default

                    break;
                case 2:
                    System.out.println("> ATUALIZAR NOME");

                    //Mostrando lista de nomes
                    System.out.println("Informações atuais da base de dados:");
                    listaNomes.consultaDados();

                    System.out.println("Digite o id que você quer alterar:");

                    id = tecladoInt.teclado();

                    System.out.println("Digite o novo nome");
                    nome = tecladoString.teclado();

                    AtualizaConnection mudaNome = new AtualizaConnection();
                    usuarioModel.setId_usuario(id);
                    usuarioModel.setNome(nome);

                    mudaNome.atualizaDados(usuarioModel.getId_usuario(), usuarioModel.getNome());

                    //Mostrando lista de nomes
                    System.out.println("\nInformações atuais da base de dados:");
                    listaNomes.consultaDados();

                    //-----
                    System.out.println("\n----");
                    System.out.println("Deseja sair? (0 - não | 1 - sim)");
                    sair = tecladoInt.teclado();

                    opcao = 0; //para abrir o default

                    break;
                case 3:
                    System.out.println("> APAGAR NOME");

                    //Mostrando lista de nomes
                    System.out.println("Informações atuais da base de dados:");
                    listaNomes.consultaDados();

                    System.out.println("Digite o id que você quer apagar:");

                    id = tecladoInt.teclado();

                    ApagaConnection apagaNome = new ApagaConnection();
                    usuarioModel.setId_usuario(id);

                    apagaNome.apagaDados(usuarioModel.getId_usuario());

                    //Mostrando lista de nomes
                    System.out.println("\nInformações atuais da base de dados:");
                    listaNomes.consultaDados();

                    //-----
                    System.out.println("\n----");
                    System.out.println("Deseja sair? (0 - não | 1 - sim)");
                    sair = tecladoInt.teclado();

                    opcao = 0; //para abrir o default

                    break;
                case 4:
                    System.out.println("> MOSTRAR NOMES");

                    ConsultaConnection verNomes = new ConsultaConnection();
                    verNomes.consultaDados();

                    //-----
                    System.out.println("\n----");
                    System.out.println("Deseja sair? (0 - não | 1 - sim)");
                    sair = tecladoInt.teclado();

                    opcao = 0; //para abrir o default

                    break;
                default:
                    menuTools.mostraMenu();
                    opcao = tecladoInt.teclado();

            }//end switch
        }//end while

        //Encerrando conexão com db
        EncerraConnection fim = new EncerraConnection();
        fim.fechaDb();
    }//end main
}//end class
