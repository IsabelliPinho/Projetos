import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar os 9 primeiros dígitos do CPF ao usuário
        System.out.print("Digite os 9 primeiros dígitos do CPF: ");
        String cpfInput = scanner.nextLine();

        // Verificar se o CPF fornecido possui 9 dígitos
        if (cpfInput.length() != 9) {
            System.out.println("CPF inválido! Deve conter 9 dígitos.");
            return; // Encerrar o programa
        }

        // Verificar se todos os dígitos do CPF são iguais
        boolean todosDigitosIguais = true;
        for (int i = 1; i < 9; i++) {
            if (cpfInput.charAt(i) != cpfInput.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }

        if (todosDigitosIguais) {
            System.out.println("CPF inválido! Todos os dígitos são iguais.");
            return; // Encerrar o programa
        }

        // Calcular o primeiro dígito verificador
        int primeiroDigito = 0;
        for (int i = 0; i < 9; i++) {
            primeiroDigito += Integer.parseInt(String.valueOf(cpfInput.charAt(i))) * (i + 1);
        }
        primeiroDigito %= 11;
        if (primeiroDigito == 10) {
            primeiroDigito = 0;
        }

        // Calcular o segundo dígito verificador
        int segundoDigito = 0;
        for (int i = 0; i < 9; i++) {
            segundoDigito += Integer.parseInt(String.valueOf(cpfInput.charAt(i))) * i;
        }
        segundoDigito += primeiroDigito * 9;
        segundoDigito %= 11;
        if (segundoDigito == 10) {
            segundoDigito = 0;
        }

        // Imprimir o CPF completo
        System.out.println("CPF completo: " + cpfInput + primeiroDigito + segundoDigito);
    }
}
