import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
        int opcao;

        // Opcional: Adicionar moedas iniciais de exemplo. Você pode remover essas linhas se quiser começar vazio.
        cofrinho.adicionar(new Real(10.0));
        cofrinho.adicionar(new Dolar(5.0));
        cofrinho.adicionar(new Euro(2.0));
        System.out.println("COFRINHO INICIALIZADO COM EXEMPLOS.");

        do {
            System.out.println("\n--- MENU COFRINHO ---");
            System.out.println("1 - Adicionar Moeda");
            System.out.println("2 - Listar Moedas");
            System.out.println("3 - Calcular Total Convertido para Real");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            // Tentativa de ler a opção
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha após o número
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número de 0 a 3.");
                scanner.nextLine(); // Limpa a entrada inválida
                opcao = -1; // Opção inválida
                continue; // Volta ao início do loop
            }

            switch (opcao) {
                case 1:
                    // Submenu de Adicionar Moeda
                    System.out.println("\n--- ADICIONAR ---");
                    System.out.println("1 - Real | 2 - Dólar | 3 - Euro");
                    System.out.print("Tipo (1/2/3): ");
                    
                    int tipoMoeda = scanner.nextInt();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Consome a quebra de linha

                    Moeda novaMoeda = null;
                    
                    if (tipoMoeda == 1) {
                        novaMoeda = new Real(valor);
                    } else if (tipoMoeda == 2) {
                        novaMoeda = new Dolar(valor);
                    } else if (tipoMoeda == 3) {
                        novaMoeda = new Euro(valor);
                    } else {
                        System.out.println("Tipo de moeda inválido. Adição cancelada.");
                        break;
                    }
                    
                    cofrinho.adicionar(novaMoeda);
                    System.out.println(novaMoeda.getClass().getSimpleName() + " adicionada!");
                    break;

                case 2:
                    // Listar Moedas
                    cofrinho.listagemMoedas();
                    break;

                case 3:
                    // Calcular Total
                    double total = cofrinho.totalConvertido();
                    System.out.printf("Total em reais: R$ %.2f%n", total);
                    break;
                    
                case 0:
                    System.out.println("Encerrando o cofrinho. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
        
        scanner.close();
    }
}