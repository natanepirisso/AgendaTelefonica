
public class Agenda {
    public static void main(String [] args){
        Pessoa p1 = new Pessoa_fisica("Natan", 30322202,"123.456.789-10");
        Pessoa p2 = new Pessoa_juridica("Balãozete LTDA", 96143230, "12.345.678/0001-95");
        p1.disponibilidade = true;
        p2.disponibilidade = false;
        System.out.println("\n------------------- Agenda -----------------------\n\n");
        Pessoa[] contatos = {p1,p2};
        for(Pessoa contato : contatos){
            contato.estaDisponivel();
            System.out.println("Nome: " + contato.nome);
            System.out.println("Número: " + contato.telNumber);
            System.out.println("Documento: " + contato.getDocument());
            System.out.println("\n---------------------");
        }
    }
}
