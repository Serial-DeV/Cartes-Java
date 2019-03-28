public class ExceptionMemePerso extends Exception{
  public ExceptionMemePerso(String nom){
  super(nom + " ne peut pas s'attaquer lui-meme");
  }
}
