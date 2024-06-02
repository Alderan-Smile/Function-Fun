package function_fun.VoidNullValidador;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.12.13                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
public class FunValLong {

    /**
     * Validates a Long object and returns its value if it's not null, or 0L if it is null.
     *
     * @param numero The Long object to be validated.
     * @return The value of the Long object if it's not null, or 0L if it is null.
     */
    public Long LongValidador(Long numero){
        if(numero == null){
            return 0L;
        }else{
            return numero;
        }
    }
}
