package function_fun.ValidadorMaxMinEqual;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202461.23.24                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
/**
 * This class contains methods for validating the difference in days between two dates.
 * It provides methods for both Date and String inputs.
 * The validation checks if the difference is less than or equal to a maximum number of days, or greater than or equal to a minimum number of days.
 */
public class FunValMMEDate {

    private static final Logger log = LogManager.getLogger(FunValMMEDate.class);

    /**
     * Validates if the difference in days between two dates is less than or equal to a maximum number of days.
     *
     * @param fechaIni The initial date.
     * @param fechaFin The final date.
     * @param diasMax The maximum number of days allowed between the initial and final date.
     * @return true if the difference in days is less than or equal to the maximum, false otherwise.
     * @throws Exception if there is an error calculating the difference in days.
     */
    public boolean valFechaMax(Date fechaIni, Date fechaFin, Integer diasMax){

        try {
            long diferencia = fechaFin.getTime() - fechaIni.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);

            if (dias >= diasMax) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            log.error("Error al validar las fechas: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the difference in days between two dates, provided as strings, is less than or equal to a maximum number of days.
     *
     * @param fechaIni The initial date as a string.
     * @param fechaFin The final date as a string.
     * @param pattern The pattern used for date parsing.
     * @param diasMax The maximum number of days allowed between the initial and final date.
     * @return true if the difference in days is less than or equal to the maximum, false otherwise.
     * @throws Exception if there is an error parsing the dates or calculating the difference in days.
     */
    public boolean valFechaMax(String fechaIni, String fechaFin, String pattern, Integer diasMax){

        try {
            Date fechaI = new Date();
            Date fechaF = new Date();
            try {
                fechaI = new SimpleDateFormat(pattern).parse(fechaIni);
                fechaF = new SimpleDateFormat(pattern).parse(fechaFin);
            } catch (Exception e) {
                log.error("Error al convertir las fechas: {}", e.getMessage());
            }

            long diferencia = fechaF.getTime() - fechaI.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);

            if (dias >= diasMax) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            log.error("Error al validar las fechas: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the difference in days between two dates is greater than or equal to a minimum number of days.
     *
     * @param fechaIni The initial date.
     * @param fechaFin The final date.
     * @param diasMin The minimum number of days required between the initial and final date.
     * @return true if the difference in days is greater than or equal to the minimum, false otherwise.
     * @throws Exception if there is an error calculating the difference in days.
     */
    public boolean valFechaMin(Date fechaIni, Date fechaFin, Integer diasMin){

        try {
            long diferencia = fechaFin.getTime() - fechaIni.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);

            if (dias <= diasMin) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            log.error("Error al validar las fechas: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the difference in days between two dates, provided as strings, is greater than or equal to a minimum number of days.
     *
     * @param fechaIni The initial date as a string.
     * @param fechaFin The final date as a string.
     * @param pattern The pattern used for date parsing.
     * @param diasMin The minimum number of days required between the initial and final date.
     * @return true if the difference in days is greater than or equal to the minimum, false otherwise.
     * @throws Exception if there is an error parsing the dates or calculating the difference in days.
     */
    public boolean valFechaMin(String fechaIni, String fechaFin, String pattern, Integer diasMin){

        try {
            Date fechaI = new Date();
            Date fechaF = new Date();
            try {
                fechaI = new SimpleDateFormat(pattern).parse(fechaIni);
                fechaF = new SimpleDateFormat(pattern).parse(fechaFin);
            } catch (Exception e) {
                log.error("Error al convertir las fechas: {}", e.getMessage());
            }

            long diferencia = fechaF.getTime() - fechaI.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);

            if (dias <= diasMin) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            log.error("Error al validar las fechas: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the difference in days between two dates is equal to zero.
     *
     * @param fechaIni The initial date.
     * @param fechaFin The final date.
     * @return true if the difference in days is equal to zero (i.e., the dates are equal), false otherwise.
     * @throws Exception if there is an error calculating the difference in days.
     */
    public boolean valFechaEqual(Date fechaIni, Date fechaFin){
        try {
            long diferencia = fechaFin.getTime() - fechaIni.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);
            if (dias == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Error al validar las fechas: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Validates if the difference in days between two dates, provided as strings, is equal to zero.
     *
     * @param fechaIni The initial date as a string.
     * @param fechaFin The final date as a string.
     * @param pattern The pattern used for date parsing.
     * @return true if the difference in days is equal to zero (i.e., the dates are equal), false otherwise.
     * @throws Exception if there is an error parsing the dates or calculating the difference in days.
     */
    public boolean valFechaEqual(String fechaIni, String fechaFin, String pattern){
        try {
            Date fechaI = new Date();
            Date fechaF = new Date();
            try {
                fechaI = new SimpleDateFormat(pattern).parse(fechaIni);
                fechaF = new SimpleDateFormat(pattern).parse(fechaFin);
            } catch (Exception e) {
                log.error("Error al convertir las fechas: {}", e.getMessage());
            }
            long diferencia = fechaF.getTime() - fechaI.getTime();
            long dias = diferencia / (1000 * 60 * 60 * 24);
            if (dias == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Error al validar las fechas: {}", e.getMessage());
            return false;
        }
    }
}
