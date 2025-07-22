public abstract class Pessoa {
    public String nome;
    public int telNumber;
    public boolean disponibilidade;
    int id;

    private static int idCounter = 1;
    public Pessoa(String nome, int telNumber) {
        this.nome = nome;
        this.telNumber = telNumber;
        this.id = idCounter++;
    }

    public void estaDisponivel(){
        if (this.disponibilidade){
            System.out.println("Status: disponível");
        }
        else{
            System.out.println("Status: indisponível");
        }
    }
    public abstract String getDocument();

}
