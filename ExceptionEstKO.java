public class ExceptionEstKO extends Exception{
  public ExceptionEstKO(String nom){
  super("Action impossible car " + nom + " est KO");
  }
}
