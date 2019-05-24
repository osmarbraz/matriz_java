
/**
 * Implementação de de operações com Matriz nxm manipulada através um menu de opções.
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Principal {

    //Número de linhas da Matriz.
    static int n = 0;
    //Número de colunas da Matriz.
    static int m = 0;
    //Matriz M de n por m.
    static double[][] A = new double[n][m];

    /**
     * Cria uma cópia da Matriz.
     *
     * @param M Matriz com os dados a serem copiados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma matriz com uma cópia dos dados da matriz de M para C.
     */
    public static double[][] criarCopia(double[][] M, int linhas, int colunas) {
        double[][] C = new double[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                C[i][j] = M[i][j];
            }
        }
        return C;
    }

    /**
     * Gera uma string formatada com os dados Matriz M.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String formatada com os dados da matriz.
     */
    public static String imprimirMatriz(double[][] M, int linhas, int colunas) {
        if (linhas != 0 || colunas != 0) {
            String saida = "";
            for (int j = 0; j < colunas; j++) {
                saida = saida + "\t" + String.format("%5d", j);
            }
            saida = "n/m" + saida + "\n";
            for (int i = 0; i < linhas; i++) {
                String dados = "";
                for (int j = 0; j < colunas; j++) {
                    dados = dados + "\t" + String.format("%4.1f", M[i][j]);
                }
                saida = saida + i + dados + "\n";
            }
            return saida;
        } else {
            return "Matriz vazia!";
        }
    }

    /**
     * Carrega uma Matriz padrão de 3x3 com valores.
     *
     */
    public static void carregarMatrizPadrao3x3() {
        //Número de linhas da Matriz.
        n = 3;
        //Número de colunas da Matriz.
        m = 3;
        //Declara uma matriz a com valores.
        double[][] a = {
            {2, -1, 3},
            {5, 2, 1},
            {3, 1, 4}
        }; //Deteterminante 28.
        //Atribui para A.
        A = a;
        JOptionPane.showMessageDialog(null, "Matriz A(3x3) carregada!");
    }

    /**
     * Realiza a leitura dos dados da Matriz A.
     */
    public static void leituraMatriz() {
        //Preenche a quantidade linhas da matriz.
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de linhas da matriz(n):"));
        //Preenche a quantidade colunas da matriz.
        m = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de colunas da matriz(m):"));
        //Instância a matriz com o novo tamanho.
        A = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor A[" + i + "," + j + "]:"));
            }
        }
    }

    /**
     * Recupera os dados da Diagonal Principal.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com os dados da diagonal principal.
     */
    public static String mostraDiagonalPrincipal(double[][] M, int linhas, int colunas) {
        String saida = "";
        //Somente para Matriz quadrada
        if (linhas == colunas) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (i == j) {
                        saida = saida + "A[" + i + "][" + j + "] = " + String.format("%4.1f", M[i][j]) + " ";
                    }
                }
            }
        } else {
            saida = "Matriz não é quadrada!";
        }
        return saida;
    }

    /**
     * Recupera os dados da Diagonal Secundária.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com os dados da diagonal secundária.
     */
    public static String mostraDiagonalSecundaria(double[][] M, int linhas, int colunas) {
        String saida = "";
        //Somente para Matriz quadrada
        if (linhas == colunas) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (i + j == linhas - 1) {
                        saida = saida + "A[" + i + "][" + j + "] = " + String.format("%4.1f", M[i][j]) + " ";
                    }
                }
            }
        } else {
            saida = "Matriz não é quadrada!";
        }
        return saida;
    }

    /**
     * Recupera os dados do Triângulo Superior.
     *
     * @param M Matriz com os dados a serem verificados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com os dados da matriz acima da diagonal principal.
     */
    public static String mostraTrianguloSuperiorPrincipal(double[][] M, int linhas, int colunas) {
        String saida = "";
        //Somente para Matriz quadrada.
        if (linhas == colunas) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (i < j) {
                        saida = saida + "A[" + i + "][" + j + "] = " + String.format("%4.1f", M[i][j]) + " ";
                    }
                }
            }
        } else {
            saida = "Matriz não é quadrada!";
        }
        return saida;
    }

    /**
     * Recupera os dados do Triângulo Inferior.
     *
     * @param M Matriz com os dados a serem verificados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com os dados da matriz abaixo da diagonal principal.
     */
    public static String mostraTrianguloInferiorPrincipal(double[][] M, int linhas, int colunas) {
        String saida = "";
        //Somente para Matriz quadrada
        if (linhas == colunas) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (i > j) {
                        saida = saida + "A[" + i + "][" + j + "] = " + String.format("%4.1f", M[i][j]) + " ";
                    }
                }
            }
        } else {
            saida = "Matriz não é quadrada!";
        }
        return saida;
    }

    /**
     * Recupera os dados do Triângulo Inferior.
     *
     * @param M Matriz com os dados a serem verificados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com os dados da matriz abaixo da diagonal secundária.
     */
    public static String mostraTrianguloInfeior(double[][] M, int linhas, int colunas) {
        String saida = "";
        //Somente para Matriz quadrada.
        if (linhas == colunas) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (i > j) {
                        saida = saida + "A[" + i + "][" + j + "] = " + String.format("%4.1f", M[i][j]) + " ";
                    }
                }
            }
        } else {
            saida = "Matriz não é quadrada!";
        }
        return saida;
    }

    /**
     * Recupera os dado do maior elemento da matriz.
     *
     * @param M Matriz com os dados a serem verificados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com o dado do maior elemento da matriz.
     */
    public static String mostraMaiorElemento(double[][] M, int linhas, int colunas) {
        int linhaMaior = 0;
        int colunaMaior = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (M[i][j] > M[linhaMaior][colunaMaior]) {
                    linhaMaior = i;
                    colunaMaior = j;
                }
            }
        }
        String saida = "A[" + linhaMaior + "][" + colunaMaior + "] = " + String.format("%4.1f", M[linhaMaior][colunaMaior]);
        return saida;
    }

    /**
     * Retorna a Matriz Transposta.
     *
     * Matriz Mnxm gera Tmxn.
     *
     * @param M Matriz com os dados a serem gerados a transposta.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String com os dados da Matriz Transposta.
     */
    public static double[][] transposta(double[][] M, int linhas, int colunas) {
        //Matriz para armazenar a transposta
        double[][] T = new double[colunas][linhas];
        //Gera a transposta
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                T[j][i] = M[i][j];
            }
        }
        return T;
    }

    /**
     * Verificar se uma dada matriz quadrada é quadrado mágico
     *
     * A soma das linhas, soma das colunas e diagonais tem de ser igual.
     *
     * @param M Matriz com os dados a serem verificados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Verdadeiro ou falso se a matriz forma um quadrado mágico.
     */
    public static boolean eQuadradoMagico(double[][] M, int linhas, int colunas) {
        //Quadrado mágico somente para matriz quadrada.
        if (linhas == colunas) {
            double soma = (linhas * linhas * linhas + linhas) / 2;
            double somaLinha = 0;
            double somaColuna = 0;
            double somaDiagonalPrincipal = 0;
            double somaDiagonalSecundaria = 0;

            //Percorre as linhas.
            for (int i = 0; i < linhas; i++) {
                // diagonal principal i=j
                somaDiagonalPrincipal = somaDiagonalPrincipal + M[i][i];
                // diagonal secundária i + j == n - 1
                somaDiagonalSecundaria = somaDiagonalSecundaria + M[i][linhas - 1 - i];
                somaLinha = 0;
                somaColuna = 0;
                //Percorre as colunas
                for (int j = 0; j < linhas; j++) {
                    // soma linha i
                    somaLinha = somaLinha + M[i][j];
                    // soma coluna i
                    somaColuna = somaColuna + M[j][i];
                }
                if ((somaLinha != soma) || (somaColuna != soma)) {
                    return false;
                }
            }
            if ((somaDiagonalPrincipal != soma) || (somaDiagonalSecundaria != soma)) {
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Matriz não é quadrada.");
            return false;
        }
    }

    /**
     * Retorna a matriz rotacionada 90 graus.
     *
     * @param M Matriz com os dados a serem rotacionados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return A matriz rotacao gerada pela rotação de 90 graus da matriz.
     */
    public static double[][] rotacao90(double[][] M, int linhas, int colunas) {
        //Somente para matriz quadrada
        if (linhas == colunas) {
            //Meio da matriz
            int meio = linhas / 2;
            //Copia a matriz A para matriz rotacao realizar a rotação
            double[][] rotacao = criarCopia(M, linhas, colunas);
            for (int i = 0; i < meio; i++) {
                for (int j = i; j < colunas - 1 - i; j++) {
                    double temp = rotacao[linhas - 1 - j][i];
                    // linha ; varia coluna
                    rotacao[linhas - 1 - j][i] = rotacao[linhas - 1 - i][linhas - 1 - j];
                    // linha n-1-i; varia coluna
                    rotacao[linhas - 1 - i][linhas - 1 - j] = rotacao[j][linhas - 1 - i];
                    // coluna n-1-i; varia linha
                    rotacao[j][linhas - 1 - i] = rotacao[i][j];
                    // linha i; varia coluna
                    rotacao[i][j] = temp;
                }
            }
            return rotacao;
        } else {
            System.out.println("A matriz não é quadrada.");
            return M;
        }
    }

    /**
     * Retorna uma matriz multiplicada por um valor.
     *
     * @param M Matriz com os dados a serem rotacionados.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @param valor Valor a ser multiplicado por cada elemento da matriz.
     * @return A matriz rotacao gerada pela rotação de 90 graus da matriz.
     */
    public static double[][] multiplicar(double[][] M, int linhas, int colunas, double valor) {
        //Copia a matriz para matriz produto da multiplicação
        double[][] produto = criarCopia(M, linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                produto[i][j] = M[i][j] * valor;
            }
        }
        return produto;
    }

    /**
     * Retorna o determinante da Matriz.
     *
     * @param M Matriz com os dados a serem gerados a transposta.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return O valor do determinante da matriz.
     */
    public static double determinante(double[][] M, int linhas, int colunas) {
        //Determinante somente para matriz quadrada
        if (linhas == colunas) {
            //Cria uma cópia da matriz A para calcular o determinante em D
            double[][] D = criarCopia(M, linhas, colunas);
            //Armazena o valor do determinante 
            double det = 1.0;
            //Matriz com 1 linha e coluna
            if (linhas == 1) {
                det = D[0][0];
            } else {
                //Matriz com 2 linhas e colunas
                if (linhas == 2) {
                    det = (D[0][0] * D[1][1]) - (D[1][0] * D[0][1]);
                } else {
                    //Matriz com 3 ou mais linhas e colunas
                    //fator de ajuste do sinal
                    double p = 1;
                    // faz a transformação em um triângulo.
                    //Percorre todas as linhas
                    for (int i = 0; i < linhas - 1; i++) {
                        if (D[i][i] == 0) {
                            for (int k = i; k < colunas; k++) {
                                //Somente para valores diferentes de 0
                                if (D[k][i] != 0) {
                                    //Troca a linha j e k
                                    for (int j = 0; j < colunas; j++) {
                                        double temp = D[i][j];
                                        D[i][j] = D[k][j];
                                        D[k][j] = temp;
                                    }
                                    p = p * (-1);
                                    //Interrompe o laço
                                    k = colunas;
                                }
                            }
                        }
                        //A é uma matriz singular
                        if (D[i][i] == 0) {
                            det = 0;
                        } else {
                            for (int k = i + 1; k < colunas; k++) {
                                double fator = -1.0 * D[k][i] / D[i][i];
                                for (int j = i; j < colunas; j++) {
                                    D[k][j] = D[k][j] + (fator * D[i][j]);
                                }
                            }
                        }
                    }
                    if (det != 0) {
                        det = 1.0;
                        // Calcula o determinante
                        for (int i = 0; i < linhas; i++) {
                            det = det * D[i][i];
                        }
                    }
                }
            }
            return det;
        } else {
            return 0;
        }
    }

    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Armazena opção lida
        int opcao = -1;
        
        //Laço do menu de opções
        while (opcao != 99) {
            //Realiza a leitura da opção
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Menu de Opções - Matriz nxm ###\n"
                    + " 1- Impressão da Matriz\n"
                    + " 2- Carregamento da Matriz (3x3)\n"
                    + " 3- Leitura de uma Matriz(nxm)\n"
                    + " 4- Mostra a Diagonal Principal\n"
                    + " 5- Mostra a Diagonal Secundária\n"
                    + " 6- Mostra o Triângulo Superior Principal\n"
                    + " 7- Mostra o Triângulo Inferior Principal\n"
                    + " 8- Mostra o Maior Elemento\n"
                    + " 9- Mostra a transposta\n"
                    + "10- É quadrado mágico\n"
                    + "11- Rotação 90 graus\n"
                    + "12- Multiplicação\n"
                    + "13- Determinante\n"
                    //Outras opções vão aqui                    
                    + "99- Sair\n"
                    + "Digite a opção desejada:"));
            //Verifica a opção
            switch (opcao) {
                case 1: {
                    //Recupera os dados da matriz
                    String dados = "Matriz:" + "\n" + imprimirMatriz(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 2: {
                    carregarMatrizPadrao3x3();
                    break;
                }
                case 3: {
                    leituraMatriz();
                    break;
                }
                case 4: {
                    //Recupera os dados da diagonal principal da matriz
                    String dados = "Diagonal Principal:" + "\n" + mostraDiagonalPrincipal(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 5: {
                    //Recupera os dados da diagonal secundária da matriz
                    String dados = "Diagonal Secundária:" + "\n" + mostraDiagonalSecundaria(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 6: {
                    //Recupera os dados da diagonal secundária da matriz
                    String dados = "Triângulo Superior Principal:" + "\n" + mostraTrianguloSuperiorPrincipal(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 7: {
                    //Recupera os dados da diagonal secundária da matriz
                    String dados = "Triângulo Inferior Principal:" + "\n" + mostraTrianguloInferiorPrincipal(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 8: {
                    //Recupera os dados da diagonal secundária da matriz
                    String dados = "Maior elemento da Matriz:" + "\n" + mostraMaiorElemento(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 9: {
                    //Recupera os dados da matriz
                    double[][] t = transposta(A, n, m);
                    String dados = "Matriz Transposta:" + "\n" + imprimirMatriz(t, m, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 10: {
                    //Verifica se a matriz é um quadrado mágico
                    if (eQuadradoMagico(A, n, m) == true) {
                        JOptionPane.showMessageDialog(null, "A Matriz forma um Quadrado Mágico.");
                    } else {
                        JOptionPane.showMessageDialog(null, "A Matriz não forma um Quadrado Mágico.");
                    }
                    break;
                }
                case 11: {
                    //Recupera os dados da matriz
                    double[][] rotacao = rotacao90(A, n, m);
                    String dados = "Matriz Rotacionada 90 graus:" + "\n" + imprimirMatriz(rotacao, m, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 12: {
                    //Realiza a leitura do valor a ser multiplicado
                    double valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para multiplicar pela matriz:"));
                    //Recupera os dados da matriz                    
                    double[][] produto = multiplicar(A, n, m, valor);
                    String dados = "Matriz multipicada por" + valor + " :" + "\n" + imprimirMatriz(produto, m, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 13: {
                    //Recupera os dados da matriz
                    String dados = "Determinante:" + "\n" + determinante(A, n, m);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                
                //Outras opções vão aqui
                
                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch
        }//Fim while
    }//Fim main
}
