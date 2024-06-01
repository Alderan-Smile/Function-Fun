package function_fun.DateAndTime;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 2024531.19.31                                                                                   *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Slf4j
public class FunDate {

    /**
    * Converts a string representation of a date and time to a Date object using the specified pattern.
    *
    * @param pattern    the pattern used to parse the string representation of the date and time
    * @param fechaHora  the string representation of the date and time
    * @return           the Date object representing the parsed date and time, or null if parsing fails
    */
    public synchronized Date StringToDate(String pattern, String fechaHora){
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        try{
            Date crono = parser.parse(fechaHora);
            return crono;
        } catch (ParseException e) {
            log.error("ERROR | Error Parse en: "+e);
            return null;
        }
    }

    /**
     * Converts a Date object to a formatted string representation using the specified pattern.
     *
     * @param pattern the pattern to be used for formatting the date
     * @param fechaHora the Date object to be converted to a string
     * @return the formatted string representation of the date, or null if an error occurs during parsing
     */
    public synchronized String DateToString(String pattern, Date fechaHora){
        SimpleDateFormat parser = new SimpleDateFormat(pattern);

        try {
            String crono = parser.format(fechaHora);
            return crono;
        } catch (Exception e) {
            log.error("ERROR | Error Parse en: "+e);
            return null;
        }
    }

    /**
    * Calculates the sum of a given number of days to a given date.
    *
    * @param fechaHora the date to which the days will be added
    * @param dias the number of days to be added
    * @return the resulting date after adding the specified number of days
    */
    public synchronized Date DateSuma(Date fechaHora, int dias){
        Calendar c = Calendar.getInstance();
        c.setTime(fechaHora);
        c.add(Calendar.DATE, dias);
        return c.getTime();
    }


    /**
     * Adds the specified number of days to the given date and returns the result as a formatted string.
     *
     * @param pattern the pattern to be used for formatting the date
     * @param fechaHora the date to which the days should be added
     * @param dias the number of days to be added
     * @return the formatted string representing the resulting date
     */
    public synchronized String DateSuma(String pattern,Date fechaHora, int dias){
        SimpleDateFormat parser = new SimpleDateFormat(pattern);

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(fechaHora);
            c.add(Calendar.DATE, dias);
            Date crono = c.getTime();
            return parser.format(crono);
        } catch (Exception e) {
            log.error("ERROR | Error Parse en: "+e);
            return null;
        }
    }
}