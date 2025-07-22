package inputExceptions;

public class inputValidators {
    public static void notString(String input ) throws notStringInputException{
        if(!input.matches("[a-zA-Z]+")){throw new notStringInputException("Erro: digite apenas letras.");}
    }
    public static void notAInt(String input) throws notAIntInputException{
        if(!input.matches("\\d+")){throw new notAIntInputException("Erro: digite apenas números inteiros.");}
    }
}
