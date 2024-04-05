import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //----------------------------------------------------------------------------------------------------------------
        Cliente clienteSemCadastro = new Cliente();
        Cliente cliente1 = new Cliente(2, "Bárbara, Luana", "Premium", "luaninha@gmail.com", "amogatos!2326", "41991468348", "TV Samsung XLK34", "Cartão de crédito", "Ru Pauls Drag Race, Mean Girls", "Carros, Carros 2" );

        List<Midia> favoritos = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nBem-vindo ao NETFLIX");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - CADASTRAR USUÁRIO");
            System.out.println("2 - ASSISTIR FILME");
            System.out.println("3 - ASSISTIR SÉRIE");
            System.out.println("4 - LISTAR FILMES");
            System.out.println("5 - LISTAR SÉRIES");
            System.out.println("6 - LISTA DE FAVORITOS");
            System.out.println("0 - SAIR");

            int escolha = scanner.nextInt();
            if (escolha == 1) {
                Cliente cliente = new Cliente(); // Criar uma instância de Cliente
                cliente.cadastrarNovoUsuario(); // Chamar o método cadastrarNovoUsuario()
            } else if (escolha == 2) {
                Midia.assistirFilme(criarListaFilmes());
            } else if (escolha == 3) {
                Serie.assistirSerie(criarListaSeries());
            } else if (escolha == 4) {
                List<Midia> filmes = criarListaFilmes();
                mostrarLista(filmes);
                int escolhaFilme = escolherMidia(filmes, scanner);
                if (escolhaFilme != -1) {
                    System.out.println("\nDigite 1 para voltar!");
                    System.out.println("Digite 2 para adicionar aos favoritos!");
                    int escolhaOpcao = scanner.nextInt();
                    if (escolhaOpcao == 2) {
                        favoritos.add(filmes.get(escolhaFilme));
                        System.out.println("\nFilme adicionado aos favoritos!");
                    }
                }
            } else if (escolha == 5) {
                List<Serie> series = criarListaSeries();
                mostrarLista(series);
                int escolhaSerie = escolherMidia(series, scanner);
                if (escolhaSerie != -1) {
                    System.out.println("\nDigite 1 para voltar!");
                    System.out.println("Digite 2 para adicionar aos favoritos!");
                    int escolhaOpcao = scanner.nextInt();
                    if (escolhaOpcao == 2) {
                        favoritos.add(series.get(escolhaSerie));
                        System.out.println("\nSérie adicionada aos favoritos!");
                    }
                }
            } else if (escolha == 6) {
                mostrarFavoritos(favoritos);
            } else if (escolha == 0) {
                continuar = false;


            } else {
                System.out.println("Escolha inválida!");
            }
        }

        scanner.close();
    }

    public static List<Midia> criarListaFilmes() {
        List<Midia> filmes = new ArrayList<>();
        filmes.add(new Midia("Comédia", 4, 10, "Português", "Espanhol", "1h 30min", "Minha Mãe é Uma Peça", "8.5", "Paulo Gustavo", 2013));
        filmes.add(new Midia("Ação", 5, 14, "Inglês", "Português", "2h 9min", "Truque de Mestre", "7.3", "Jesse Eisenberg, Mark Ruffalo", 2013));
        filmes.add(new Midia("Ação", 5, 14, "Inglês", "Português", "2h 12min", "O Protetor", "7.2", "Denzel Washington, Marton Csokas", 2014));
        return filmes;
    }

    public static List<Serie> criarListaSeries() {
        List<Serie> series = new ArrayList<>();
        series.add(new Serie("Drama", 5, 16, "Espanhol", "Português", "1h", "La Casa de Papel", "8.3", "Úrsula Corberó, Álvaro Morte", 2017, 5, 2, 1, "Episódio 1"));
        series.add(new Serie("Drama", 4, 18, "Coreano", "Português", "1h", "Round 6", "7.7", "Lee Jung-jae, Park Hae-soo", 2021, 1, 1, 1, "Round 1"));
        series.add(new Serie("Drama", 4, 14, "Inglês", "Português", "42min", "Gossip Girl", "7.3", "Blake Lively, Leighton Meester", 2007, 6, 1, 1, "Pilot"));
        return series;
    }

    public static void mostrarLista(List<? extends Midia> midias) {
        for (int i = 0; i < midias.size(); i++) {
            System.out.println((i + 1) + ". " + midias.get(i).getNome());
        }
    }

    public static int escolherMidia(List<? extends Midia> midias, Scanner scanner) {
        System.out.println("\nDigite o número da mídia para ver mais informações ou 0 para voltar:");
        int escolha = scanner.nextInt();
        if (escolha == 0) {
            return -1;
        } else if (escolha >= 1 && escolha <= midias.size()) {
            Midia midiaSelecionada = midias.get(escolha - 1);
            if (midiaSelecionada instanceof Serie) {
                Serie serieSelecionada = (Serie) midiaSelecionada;
                serieSelecionada.mostrarSerie();
            } else {
                midiaSelecionada.mostrarMidia();
            }
            return escolha - 1;
        } else {
            System.out.println("Escolha inválida!");
            return -1;
        }
    }

    public static void mostrarFavoritos(List<Midia> favoritos) {
        if (favoritos.isEmpty()) {
            System.out.println("\nLista de favoritos vazia!");
        } else {
            System.out.println("\nLista de favoritos:");
            for (Midia favorito : favoritos) {
                if (favorito instanceof Serie) {
                    Serie serieFavorita = (Serie) favorito;
                    System.out.println("\n--------------Série----------------");
                    System.out.println("Nome: " + serieFavorita.getNome());
                    System.out.println("Gênero: " + serieFavorita.getGenero());
                    System.out.println("Relevância: " + serieFavorita.getRelevancia());
                    System.out.println("Ano de lançamento: " + serieFavorita.getAnoDeLancamento());
                    System.out.println("Duração: " + serieFavorita.getDuracao());
                    System.out.println("Classificação indicativa: " + serieFavorita.getClassificacaoIndicativa());
                    System.out.println("Língua disponível: " + serieFavorita.getLinguaDisponivel());
                    System.out.println("Legenda disponível: " + serieFavorita.getLegendaDisponivel());
                    System.out.println("Classificação popularidade: " + serieFavorita.getClassificacaoRankingPopularidade());
                    System.out.println("Elenco: " + serieFavorita.getElenco());
                    System.out.println("Quantidade de episódios: " + serieFavorita.getQuantidadeDeEpisodio());
                    System.out.println("Quantidade de temporadas: " + serieFavorita.getQuantidadeDeTemporadas());
                    System.out.println("Número do episódio: " + serieFavorita.getNumeroDoEpisodio());
                    System.out.println("Nome do episódio: " + serieFavorita.getNomeDoEpisodio());
                } else {
                    Midia filmeFavorito = favorito;
                    System.out.println("\n--------------Filme----------------");
                    System.out.println("Nome: " + filmeFavorito.getNome());
                    System.out.println("Gênero: " + filmeFavorito.getGenero());
                    System.out.println("Relevância: " + filmeFavorito.getRelevancia());
                    System.out.println("Ano de lançamento: " + filmeFavorito.getAnoDeLancamento());
                    System.out.println("Duração: " + filmeFavorito.getDuracao());
                    System.out.println("Classificação indicativa: " + filmeFavorito.getClassificacaoIndicativa());
                    System.out.println("Língua disponível: " + filmeFavorito.getLinguaDisponivel());
                    System.out.println("Legenda disponível: " + filmeFavorito.getLegendaDisponivel());
                    System.out.println("Classificação popularidade: " + filmeFavorito.getClassificacaoRankingPopularidade());
                    System.out.println("Elenco: " + filmeFavorito.getElenco());
                }
            }
        }
    }
}
