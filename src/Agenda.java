
public class Agenda {
    public static void main(String [] args){
        Pessoa_fisica p1 = new Pessoa_fisica("Natan", 30322202,"123.456.789-10");
        Pessoa_juridica p2 = new Pessoa_juridica("Balãozete LTDA", 96143230, "12.345.678/0001-95");
        p1.disponibilidade = true;
        p2.disponibilidade = false;
        System.out.println("\n------------------- Agenda -----------------------\n\n");
        p1.estaDisponivel();
        System.out.println("Nome: " + p1.nome +"\nNúmero: "+ p1.telNumber+"\nDocumento de identidade: "+ p1.cpf+"\n"+"\n---------------------" );
        p2.estaDisponivel();
        System.out.println("Nome: " + p2.nome +"\nNúmero: "+ p2.telNumber+"\nDocumento de identidade: "+ p2.cnpj+"\n"+"\n---------------------" );
    }
}
