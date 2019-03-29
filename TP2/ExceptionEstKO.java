public class ExceptionEstKO extends Exception{
  private static final long serialVersionUID = 1L;
  public ExceptionEstKO(String nom){
  super("Action impossible car " + nom + " est KO");
  }
}
