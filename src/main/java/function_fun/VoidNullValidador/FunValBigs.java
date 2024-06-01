package function_fun.VoidNullValidador;

import java.math.BigDecimal;
import java.math.BigInteger;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.12.19                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/

public class FunValBigs {

    /**
     * Validates a BigDecimal object and returns its value if it's not null, or BigDecimal.ZERO if it is null.
     *
     * @param numero The BigDecimal object to be validated.
     * @return The value of the BigDecimal object if it's not null, or BigDecimal.ZERO if it is null.
     */
    public BigDecimal BigDecimalValidador(BigDecimal numero){
        if(numero == null){
            return BigDecimal.ZERO;
        }else{
            return numero;
        }
    }

    /**
     * Validates a BigInteger object and returns its value if it's not null, or BigInteger.ZERO if it is null.
     *
     * @param numero The BigInteger object to be validated.
     * @return The value of the BigInteger object if it's not null, or BigInteger.ZERO if it is null.
     */
    public BigInteger BigIntegerValidador(BigInteger numero){
        if(numero == null){
            return BigInteger.ZERO;
        }else{
            return numero;
        }
    }
}
