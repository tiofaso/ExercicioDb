import connection.*;
import model.Usuario;
import tools.LeitorTecladoInt;
import tools.LeitorTecladoString;
import tools.Menu;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        //Instanciando usuário
        Usuario usuario = new Usuario();

        Menu menu = new Menu();
        menu.mostraMenu();

        //Instanciando teclados
        LeitorTecladoInt tecladoInt = new LeitorTecladoInt();
        LeitorTecladoString tecladoString = new LeitorTecladoString();

        //Instanciando variáveis
        int id;
        String nome;
        int opcao;

        //Lendo teclado do menu
        opcao = tecladoInt.teclado();

        //Instanciando a exibição de nomes
        Consulta listaNomes = new Consulta();

        //Setando opção para sair do programa
        int sair = 0;

        while (sair == 0){

            //Executando as opções do menu
            switch (opcao) {
                case 1:
                    System.out.println("> INSERIR NOME");
                    System.out.println("Digite um nome:");

                    nome = tecladoString.teclado();

                    usuario.setNome(nome);

                    Insere novoNome = new Insere();
                    novoNome.insereDados(usuario.getNome());

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

                    Atualiza mudaNome = new Atualiza();
                    usuario.setId_usuario(id);
                    usuario.setNome(nome);

                    mudaNome.atualizaDados(usuario.getId_usuario(), usuario.getNome());

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

                    Apaga apagaNome = new Apaga();
                    usuario.setId_usuario(id);

                    apagaNome.apagaDados(usuario.getId_usuario());

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

                    Consulta verNomes = new Consulta();
                    verNomes.consultaDados();

                    //-----
                    System.out.println("\n----");
                    System.out.println("Deseja sair? (0 - não | 1 - sim)");
                    sair = tecladoInt.teclado();

                    opcao = 0; //para abrir o default

                    break;
                default:
                    menu.mostraMenu();
                    opcao = tecladoInt.teclado();

            }//end switch
        }//end while

        //Encerrando conexão com db
        EncerraConexao fim = new EncerraConexao();
        fim.fechaDb();
    }//end main
}//end class
