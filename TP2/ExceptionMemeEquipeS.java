public class ExceptionMemeEquipeS extends Exception{
  private static final long serialVersionUID = 1L;
  public ExceptionMemeEquipeS(String nom, String equipe){
  super(nom + " ne peut pas soigner un membre d'une autre equipe (" + equipe + ")" );
  }
}
