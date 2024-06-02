package function_fun.VoidNullValidador;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.0.1                                                                                      *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
/**
 * This class contains methods for validating Integer objects.
 * It provides a method to check if an Integer object is null and returns its value if it's not null, or 0 if it is null.
 */
public class FunValInt {

    /**
     * Validates an Integer object and returns its value if it's not null, or 0 if it is null.
     *
     * @param numero The Integer object to be validated.
     * @return The value of the Integer object if it's not null, or 0 if it is null.
     */
    public Integer IntegerValidador(Integer numero){
        if(numero == null){
            return 0;
        }else{
            return numero;
        }
    }
}
