import java.util.Scanner;
public class Cliente {
    private Integer numeroPerfis;
    private String nomePerfis;
    private String plano;
    private String email;
    private String senha;
    private String celular;
    private String aparelhosConectados;
    private String metodoPagamento;
    private String historicoVisualizacao;
    private String listaFavoritos;

    public Cliente(int numeroPerfis, String nomePerfis, String plano, String email, String senha, String celular, String aparelhosConectados, String metodoPagamento, String historicoVisualizacao, String listaFavoritos) {
        this.numeroPerfis = numeroPerfis;
        this.nomePerfis = nomePerfis;
        this.plano = plano;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.aparelhosConectados = aparelhosConectados;
        this.metodoPagamento = metodoPagamento;
        this.historicoVisualizacao = historicoVisualizacao;
        this.listaFavoritos = listaFavoritos;
    }

    public Cliente(){
        this(0, "sem nome", "sem plano", "exemplo@gmail.com", "senhaexemplo", "1234567890", "Nenhum aparelho conectado", "sem método", "histórico vazio", "sem favoritos");
    }

    public void setNumeroPerfis(Integer numeroPerfis) {
        this.numeroPerfis = numeroPerfis;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNomePerfis(String nomePerfis){
        this.nomePerfis = nomePerfis;
    }

    public void setPlano(String plano){
        this.plano = plano;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }

    public void setAparelhosConectados(String aparelhosConectados){
        this.aparelhosConectados = aparelhosConectados;
    }

    public void setMetodoPagamento(String aparelhosConectados){
        this.metodoPagamento = metodoPagamento;
    }

    public  void setListaFavoritos(String listaFavoritos){
        this.listaFavoritos = listaFavoritos;
    }

    public String getHistoricoVisualizacao(){
        return historicoVisualizacao;
    }
    public void exibirInformacoes(){
        System.out.println("Número de perfis: " + numeroPerfis + "Perfis: " + nomePerfis + "Plano atual: " + plano + "Aparelhos conectados: " + aparelhosConectados);
    }
    public void exibirDadosPessoais(){
        System.out.println("Email cadastrado: " + email + "Celular: " + celular + "Método de pagamento: " + metodoPagamento);
    }
    public void exibirFavoritos(){
        System.out.println("Seus favoritos: " + listaFavoritos);
    }
    public void exibirHistorico(){
        System.out.println("Histórico: " + historicoVisualizacao);
    }
    public void atualizarInformacoes(){

    }
    public void assistirConteudo(){
        System.out.println("▶️");
    }

    public void cadastrarNovoUsuario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCadastro de novo usuário:");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Celular: ");
        String celular = scanner.nextLine();

        this.numeroPerfis = 0;
        this.nomePerfis = "NULL";
        this.plano = "NULL";
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.aparelhosConectados = "NULL";
        this.metodoPagamento = "NULL";
        this.historicoVisualizacao = "NULL";
        this.listaFavoritos = "NULL";

        System.out.println("\nUsuário cadastrado com sucesso!");
    }
}