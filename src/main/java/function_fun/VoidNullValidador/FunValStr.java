package function_fun.VoidNullValidador;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.0.1                                                                                      *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
/**
 * This class contains methods for validating String objects.
 * It provides a method to check if a String object is null and returns its value if it's not null, or an empty string if it is null.
 */
public class FunValStr {

    /**
     * Validates a String object and returns its value if it's not null, or an empty string if it is null.
     *
     * @param texto The String object to be validated.
     * @return The value of the String object if it's not null, or an empty string if it is null.
     */
    public String StringValidador(String texto){
        if(texto == null){
            return "";
        }else{
            return texto;
        }
    }
}
