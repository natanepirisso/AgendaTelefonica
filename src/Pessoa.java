public abstract class Pessoa {
    public String nome;
    public int telNumber;
    public boolean disponibilidade;
    public Pessoa(String nome, int telNumber){
        this.nome = nome;
        this.telNumber = telNumber;
    }
    public void estaDisponivel(){
        if (this.disponibilidade == true){
            System.out.println("Status: disponível");
        }
        else{
            System.out.println("Status: indisponível");
        }
    }
}
