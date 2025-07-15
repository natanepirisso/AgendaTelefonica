import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Agenda {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> contatos = new ArrayList<>();
        int options;
        do {
            System.out.println("------- Agenda Telefônica ------------\n");
            System.out.println("Digite:");
            System.out.println("1: Adicionar Contato");
            System.out.println("2: Ler contatos");
            System.out.println("3: Atualizar contato");
            System.out.println("4: Remover contato");
            System.out.println("0: Sair");
            options = sc.nextInt();


            switch (options) {
                case 1:
                    System.out.println("Nome:");
                    String nome = sc.next();
                    System.out.println("Telefone:");
                    int tel;
                    try{
                        tel = sc.nextInt();

                    }catch(InputMismatchException e){
                        throw new IllegalArgumentException("Telefone invalido. Veja se está correto");
                }
                    System.out.println("Pessoa física (1) ou jurídica (2)?");
                    int setEntidade =  InputUtils.getEntidade(sc);
                    if(setEntidade == 1){
                        System.out.println("digite o CPF:");
                        String cpf = sc.next();
                        contatos.add(new Pessoa_fisica(nome, tel, cpf));
                    }
                    else{
                        System.out.println("digite o CNPJ");
                        String cnpj = sc.next();
                        contatos.add(new Pessoa_juridica(nome,tel,cnpj));
                    }
                    System.out.println("Contato Adicionado!");
                break;
                case 2:
                    System.out.println("----------- Lista de Contatos ---------------");
                    for(Pessoa p : contatos){
                        System.out.println("Nome: " + p.nome + " | Telefone: " + p.telNumber + " | Identidade: " + p.getDocument());
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do contato que quer atualizar");
                    String nomeEscolhido = sc.next();
                    for(Pessoa p : contatos){
                        if(Objects.equals(p.nome, nomeEscolhido)) {
                            System.out.println("Contato encontrado. Qual o novo número de telefone?");
                            p.telNumber = sc.nextInt();
                            System.out.println("Contato Atualizado");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Qual o nome do contato que deseja excluir? Depois que digitar o nome, não tem mais volta.");
                    String contactToBeDeleted = sc.next();
                    contatos.removeIf( p -> p.nome.equals(contactToBeDeleted));
                    System.out.println("Contato Excluido");
                    break;
            }
        }
        while(options!= 0);{
            sc.close();
        }
    }
}
