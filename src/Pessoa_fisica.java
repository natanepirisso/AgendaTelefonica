public class Pessoa_fisica extends Pessoa {
    String cpf;
    public Pessoa_fisica(String nome, int telNumber,String cpf){
        super(nome, telNumber);
        this.cpf = cpf;
    }
}
