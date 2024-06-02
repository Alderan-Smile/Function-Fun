package function_fun.VoidNullValidador;

import java.util.Date;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.0.5                                                                                      *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
/**
 * This class contains methods for validating Date objects.
 * It provides a method to check if a Date object is null and returns its value if it's not null, or a new Date object if it is null.
 */
public class FunValDate {

    /**
     * Validates a Date object and returns its value if it's not null, or a new Date object if it is null.
     *
     * @param fechaHora The Date object to be validated.
     * @return The value of the Date object if it's not null, or a new Date object if it is null.
     */
    public Date DateValidador(Date fechaHora){
        if(fechaHora == null){
            return new Date();
        }else{
            return fechaHora;
        }
    }
}
