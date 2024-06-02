package function_fun.VoidNullValidador;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.12.20                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
/**
 * This class contains methods for validating Float objects.
 * It provides a method to check if a Float object is null and returns its value if it's not null, or 0.0f if it is null.
 */
public class FunValFloat {

    /**
     * Validates a Float object and returns its value if it's not null, or 0.0f if it is null.
     *
     * @param numero The Float object to be validated.
     * @return The value of the Float object if it's not null, or 0.0f if it is null.
     */
    public Float FloatValidador(Float numero){
        if(numero == null){
            return 0.0f;
        }else{
            return numero;
        }
    }
}
