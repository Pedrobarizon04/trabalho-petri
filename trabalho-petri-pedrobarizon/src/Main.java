import java.util.Scanner;

public class Main {

    public static void inserirProdutos(String [][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarProdutos(matriz, linhas, colunas);
        do {
            System.out.println("Informe onde você deseja inserir o produto com valores de 1 à " + linhas);
            linha = scanner.nextInt();
        } while(linha < 1 || linha > linhas);

        System.out.println("Insira o nome do produto: ");
        matriz[linha-1][0] = scanner.next();
        System.out.println("Insira a quantidade de produtos: ");
        matriz[linha-1][1] = scanner.next();
        System.out.println("Insira o valor do produto: ");
        matriz[linha-1][2] = scanner.next();
        System.out.println("Produto adicionado.");
    }

    public static void mostrarProdutos(String [][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Produto | Quantidade | Valor");
        for(int i = 0; i < linhas; i++) {
            System.out.print((i+1) + " - ");
            for(int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");

            }
            System.out.println();
        }
    }

    public static void calcularValor(String [][] matriz, int linhas) {
        Scanner scanner = new Scanner(System.in);
        Float valorFinal = 0.0f;
        for(int i = 0; i < linhas; i++) {
            if(matriz[i][0] != null) {
                valorFinal = valorFinal + Float.parseFloat(matriz[i][1]) * Float.parseFloat(matriz[i][2]);
            }
        }
        System.out.println("Valor final da lista de compras: " + valorFinal + " R$");
    }

    public static void removerProduto(String [][] matriz, int linhas, String nomeProduto) {
        boolean encontrado = false;
        for(int i = 0; i < linhas; i++) {
            if(matriz[i][0] != null && matriz[i][0].equals(nomeProduto)) {
                encontrado = true;
                matriz[i][0] = null;
                matriz[i][1] = null;
                matriz[i][2] = null;
            }
        }
        if(encontrado) {
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    public static void calcularValorProduto(String[][] matriz, int linhas, String nomeProduto) {
        float valorProduto = 0.0f;
        boolean encontrado = false;

        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null && matriz[i][0].equals(nomeProduto)) {
                encontrado = true;
                valorProduto = Float.parseFloat(matriz[i][1]) * Float.parseFloat(matriz[i][2]);
                break;
            }
        }

        if (encontrado) {
            System.out.println("Valor do produto '" + nomeProduto + "': " + valorProduto + " R$");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void editarProduto(String[][] matriz, int linhas, String nomeProduto) {
        boolean encontrado = false;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null && matriz[i][0].equals(nomeProduto)) {
                encontrado = true;
                System.out.println("Informe o novo nome do produto: ");
                matriz[i][0] = scanner.next();
                System.out.println("Informe a nova quantidade de produtos: ");
                matriz[i][1] = scanner.next();
                System.out.println("Informe o novo valor do produto: ");
                matriz[i][2] = scanner.next();
                break;
            }
        }

        if (encontrado) {
            System.out.println("Produto editado.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void mostrarProdutoMenorValor(String[][] matriz, int linhas, int colunas) {
        float menorValor = Float.MAX_VALUE;
        String produtoMenorValor = "";

        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null) {
                float valorProduto = Float.parseFloat(matriz[i][2]);
                if (valorProduto < menorValor) {
                    menorValor = valorProduto;
                    produtoMenorValor = matriz[i][0];
                }
            }
        }

        if (!produtoMenorValor.isEmpty()) {
            System.out.println("O produto de menor valor é: " + produtoMenorValor);
        } else {
            System.out.println("Não há produtos na lista de compras.");
        }
    }

    public static void mostrarProdutoMaiorValor(String[][] matriz, int linhas, int colunas) {
        float maiorValor = Float.MIN_VALUE;
        String produtoMaiorValor = "";

        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null) {
                float valorProduto = Float.parseFloat(matriz[i][2]);
                if (valorProduto > maiorValor) {
                    maiorValor = valorProduto;
                    produtoMaiorValor = matriz[i][0];
                }
            }
        }

        if (!produtoMaiorValor.isEmpty()) {
            System.out.println("O produto de maior valor é: " + produtoMaiorValor);
        } else {
            System.out.println("Não há produtos na lista de compras.");
        }
    }



    public static void main(String[] args) {
        String [][] lista;
        int produtos, opcao;
        int colunas = 3;
        Scanner scanner = new Scanner(System.in);
        String nomeProduto;

        System.out.println("Insira a quantidade de produtos que serão inseridos na sua lista de compras:");
        produtos = scanner.nextInt();
        lista = new String[produtos][colunas];

        do {
            System.out.println("Escolha uma opção: \n 1 - Mostrar lista de compras. \n 2 - Inserir produtos na lista de compras. \n 3 - Calcular valor dos produtos da lista de compras. \n 4 - Remover produto da lista de compras. \n 5 - Calcular valor de um produto apenas \n 6 - Editar informações de um produto \n 7 - Mostrar produto de menor valor \n 8 - Mostrar produto de maior valor \n 0 - Sair.");
            opcao = scanner.nextInt();
            switch(opcao) {
                case 0:
                    break;
                case 1:
                    mostrarProdutos(lista, produtos, colunas);
                    break;
                case 2:
                    inserirProdutos(lista, produtos, colunas);
                    break;
                case 3:
                    calcularValor(lista, produtos);
                    break;
                case 4:
                    System.out.println("Insira o produto a ser removido.");
                    nomeProduto = scanner.next();
                    removerProduto(lista, produtos, nomeProduto);
                    break;
                case 5:
                    System.out.println("Insira o nome do produto para calcular o valor dele separado: ");
                    nomeProduto = scanner.next();
                    calcularValorProduto(lista, produtos, nomeProduto);
                    break;
                case 6:
                    System.out.println("Insira o nome do produto para ser editado: ");
                    nomeProduto = scanner.next();
                    editarProduto(lista, produtos, nomeProduto);
                    break;
                case 7:
                    mostrarProdutoMenorValor(lista, produtos, colunas);
                    break;
                case 8:
                    mostrarProdutoMaiorValor(lista, produtos, colunas);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}