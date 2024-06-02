package function_fun.VoidNullValidador;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.12.15                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
public class FunValDouble {

    /**
     * Validates a Double object and returns its value if it's not null, or 0.0 if it is null.
     *
     * @param numero The Double object to be validated.
     * @return The value of the Double object if it's not null, or 0.0 if it is null.
     */
    public Double DoubleValidador(Double numero){
        if(numero == null){
            return 0.0;
        }else{
            return numero;
        }
    }
}
