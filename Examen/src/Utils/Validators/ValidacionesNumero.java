package Utils.Validators;

public class ValidacionesNumero {
    public static boolean numeroValido(String numero){
        try{
            Long.parseLong(numero);
            return true;
        } catch (Exception e){
            System.out.println("El dato debe ser un numero");
            return false;
        }
    }
}
