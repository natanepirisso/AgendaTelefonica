public class Pessoa_juridica extends Pessoa{
    String cnpj;
    public Pessoa_juridica(String nome,int telNumber,String cnpj){
        super(nome,telNumber);
        this.cnpj = cnpj;
    }
    public String getDocument(){
        return cnpj;
    }
}
