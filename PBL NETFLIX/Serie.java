import java.util.List;
import java.util.Scanner;

public class Serie extends Midia {

    private int quantidade_de_episodio;
    private int quantidade_de_temporadas;
    private int numero_do_episodio;
    private String nome_do_episodio;


    public Serie(String genero, int relevancia, int classificacao_indicativa,
                 String lingua_disponivel, String legenda_disponivel,
                 String duracao, String nome,
                 String classificacao_popularidade, String elenco,
                 int ano_Lancamento,int quantidade_de_episodio, int quantidade_de_temporadas, int numero_do_episodio, String nome_do_episodio) {
        super(genero, relevancia, classificacao_indicativa, lingua_disponivel, legenda_disponivel,duracao, nome,classificacao_popularidade, elenco,ano_Lancamento);
        this.quantidade_de_episodio = quantidade_de_episodio;
        this.quantidade_de_temporadas = quantidade_de_temporadas;
        this.numero_do_episodio = numero_do_episodio;
        this.nome_do_episodio = nome_do_episodio;
    }

    public int getQuantidadeDeEpisodio() {
        return quantidade_de_episodio;
    }

    public int getQuantidadeDeTemporadas() {
        return quantidade_de_temporadas;
    }

    public int getNumeroDoEpisodio() {
        return numero_do_episodio;
    }

    public String getNomeDoEpisodio() {
        return nome_do_episodio;
    }

    public void mostrarSerie() {
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.println("Relevância: " + relevancia);
        System.out.println("Ano de lançamento: " + ano_Lancamento);
        System.out.println("Duração: " + duracao);
        System.out.println("Classificação indicativa: " + classificacao_Indicativa);
        System.out.println("Língua disponível: " + lingua_Disponivel);
        System.out.println("Legenda disponível: " + legenda_Disponivel);
        System.out.println("Classificação popularidade: " + classificacao_popularidade);
        System.out.println("Elenco: " + elenco);
        System.out.println("Quantidade de episódios: " + quantidade_de_episodio);
        System.out.println("Quantidade de temporadas: " + quantidade_de_temporadas);
        System.out.println("Número do episódio: " + numero_do_episodio);
        System.out.println("Nome do episódio: " + nome_do_episodio);
    }
    public static void assistirSerie(List<Serie> series) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da série: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;
        for (Serie serie : series) {
            if (serie.getNome().equalsIgnoreCase(nome)) {
                System.out.println(nome + " está passando 😘❤️");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Série indisponível");
        }
    }


}