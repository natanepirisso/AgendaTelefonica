import java.util.Scanner;

public class InputUtils {
    public static int getEntidade(Scanner sc){
        if(!sc.hasNextInt()){
            throw new IllegalArgumentException("Tipo invalido! Retorne um número!");
        }
        int tipo = sc.nextInt();
        if(tipo != 2 && tipo != 1){
            throw new IllegalArgumentException("Número inválido! Escolha 1 ou 2!");
        }
        return tipo;
    }
}
