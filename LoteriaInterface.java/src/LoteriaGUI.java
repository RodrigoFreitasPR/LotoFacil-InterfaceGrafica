import java.util.Random;
import javax.swing.JOptionPane;

public class LoteriaGUI {

    public static void main(String[] args) {
        Random random = new Random();
        int escolha;

        do {
            String[] options = {"Apostar de 0 a 100", "Apostar de A à Z", "Apostar em par ou ímpar", "Sair"};
            escolha = JOptionPane.showOptionDialog(null, "Menu LOTOFÁCIL", "Loteria",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    apostarDe0a100(random);
                    break;
                case 1:
                    apostarDeAaZ();
                    break;
                case 2:
                    apostarParOuImpar();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 3);
    }

    private static void apostarDe0a100(Random random) {
        int numeroSorteado = random.nextInt(101);
        String aposta = JOptionPane.showInputDialog("Digite um número de 0 a 100:");

        try {
            int numeroAposta = Integer.parseInt(aposta);

            if (numeroAposta < 0 || numeroAposta > 100) {
                JOptionPane.showMessageDialog(null, "Aposta inválida.");
                return;
            }

            if (numeroAposta == numeroSorteado) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroSorteado + ".");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido.");
        }
    }

    private static void apostarDeAaZ() {
        String aposta = JOptionPane.showInputDialog("Digite uma letra de A à Z:");
        char letraAposta = aposta.toUpperCase().charAt(0);

        if (!Character.isLetter(letraAposta)) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
            return;
        }

        char letraPremiada = 'R';

        if (letraAposta == letraPremiada) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada + ".");
        }
    }

    private static void apostarParOuImpar() {
        String numeroStr = JOptionPane.showInputDialog("Digite um número inteiro:");
        try {
            int numero = Integer.parseInt(numeroStr);

            if (numero % 2 == 0) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro válido.");
        }
    }
}