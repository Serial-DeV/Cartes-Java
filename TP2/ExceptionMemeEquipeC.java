public class ExceptionMemeEquipeC extends Exception{
  private static final long serialVersionUID = 1L;
  public ExceptionMemeEquipeC(String nom, String equipe){
  super(nom + " ne peut pas attaquer un membre de son equipe (" + equipe + ")" );
  }
}
