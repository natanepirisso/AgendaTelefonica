import inputExceptions.inputValidators;
import inputExceptions.notAIntInputException;
import inputExceptions.notStringInputException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Agenda {
    Scanner sc;
    ArrayList<Pessoa> contatos;
    public Agenda(){
        this.sc = new Scanner(System.in);
        this.contatos = new ArrayList<>();
    }
    public void run(){
        int options;
        do{
            System.out.println("---------- Agenda Telefônica ------------");
            System.out.println("\nSelecione as opções:");
            System.out.println("1: Adicionar contato.");
            System.out.println("2: Listar contatos.");
            System.out.println("3: Atualizar contato.");
            System.out.println("4: Remover contato.");
            System.out.println("0: Encerrar");
            options = sc.nextInt();
            switch (options){
                case 1:
                    addContato();
                    break;
                case 2:
                    listarContato();
                    break;
                case 3:
                    attContato();
                    break;
                case 4:
                    deleteContato();
                    break;
            }
        }while(options != 0);{
            System.out.print("Sistema Encerrado.");
            sc.close();
        }
    }
    private void addContato(){
        while(true){
            try{
                System.out.println("Qual o nome do contato?");
                String nome = sc.next();
                inputValidators.notString(nome);
                System.out.println("Qual o número do contato?");
                String strNumber = sc.next();
                inputValidators.notAInt(strNumber);
                int intNumber = Integer.parseInt(strNumber);
                Pessoa pessoa = declararPessoa(nome, intNumber);
                contatos.add(pessoa);
                System.out.println(pessoa.nome + " foi adicionado(a) na lista de contatos.");
                break;
            }catch(notStringInputException | notAIntInputException e){
                System.out.println(e.getMessage());
            }
        }



    }
    private void listarContato(){
        System.out.println("------------------- Sua Agenda ----------------\n");
        for(Pessoa p : contatos){
            System.out.println("Nome: " + p.nome + " | Número: "+ p.telNumber +  " | Documento: " + p.getDocument() + " | ID: " + p.id);
        }
    }
    private void attContato(){
        System.out.println("Digite o ID do contato que deseja atualizar");
        while(true){
            int contactId = sc.nextInt();
            Pessoa p = encontrarPorId(contactId);
            if(p != null){
                System.out.println("Contato encontrada. Qual o novo número de telefone?");
                p.telNumber = sc.nextInt();
                System.out.println("Contato atualizado.");
                break;
            }
            else{
                System.out.println("Contato Não encontrado. Digite corretamente o ID.");
            }

        }

    }
    private void deleteContato(){
        System.out.println("Qual o id do contato que deseja excluir? Depois que digitar, não tem mais volta.");
        int contactToBeDeleted = sc.nextInt();
        contatos.removeIf( p -> p.id == contactToBeDeleted);
        System.out.println("Contato Excluido");
    }
    private Pessoa declararPessoa(String nome, int numero) {
        while (true) {
            System.out.println("É pessoa física (1) ou pessoa jurídica (2)?");
            String escolha = sc.next();
            if (Objects.equals(escolha, "1")) {
                System.out.println("Digite o CPF do contato");
                String cpf = sc.next();
                return new Pessoa_fisica(nome, numero, cpf);
            } else if (Objects.equals(escolha, "2")) {
                System.out.println("Digite o CNPJ do contato");
                String cnpj = sc.next();
                return new Pessoa_juridica(nome, numero, cnpj);
            } else if (escolha.matches("[a-zA-z]+")) {
                System.out.println("Digito incorreto. Digite 1 ou 2.");
            }
        }
    }
    private Pessoa encontrarPorId(int id) {
        for (Pessoa p : contatos) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

}
