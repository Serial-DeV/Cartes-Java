public class ExceptionMemePerso extends Exception{
  private static final long serialVersionUID = 1L;
  public ExceptionMemePerso(String nom){
  super(nom + " ne peut pas s'attaquer lui-meme");
  }
}
