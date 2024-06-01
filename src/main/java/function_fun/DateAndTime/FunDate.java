package function_fun.DateAndTime;

import function_fun.VoudNullValidador.FunValDate;
import function_fun.VoudNullValidador.FunValInt;
import function_fun.VoudNullValidador.FunValStr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 2024531.19.31                                                                                   *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
public class FunDate {

    private static final Logger log = LogManager.getLogger(FunDate.class);
    
    FunValInt funValInt = new FunValInt();
    FunValStr funValStr = new FunValStr();
    FunValDate funValDate = new FunValDate();

    /**
    * Converts a string representation of a date and time to a Date object using the specified pattern.
    *
    * @param pattern    the pattern used to parse the string representation of the date and time
    * @param fechaHora  the string representation of the date and time
    * @return           the Date object representing the parsed date and time, or null if parsing fails
    */
    public synchronized Date StringToDate(String pattern, String fechaHora){
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));
        try{
            Date crono = parser.parse(funValStr.StringValidador(fechaHora));
            return crono;
        } catch (ParseException e) {
            log.error("ERROR | Fecha vacia o Pattern Vacio: {}",e.getMessage());
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
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));

        try {
            String crono = parser.format(funValDate.DateValidador(fechaHora));
            return crono;
        } catch (Exception e) {
            log.error("ERROR | Pattern Vacio: {}",e.getMessage());
            return null;
        }
    }

    /**
    * Calculates the sum of a given number of days to a given date.
    *
    * @param fechaHora the date to which the days will be added
    * @param day the number of days to be added
    * @return the resulting date after adding the specified number of days
    */
    public synchronized Date DateSumaDay(Date fechaHora, Integer day){
        Calendar c = Calendar.getInstance();
        c.setTime(funValDate.DateValidador(fechaHora));
        c.add(Calendar.DATE, funValInt.IntegerValidador(day));
        return c.getTime();
    }


    /**
     * Adds the specified number of days to the given date and returns the result as a formatted string.
     *
     * @param pattern the pattern to be used for formatting the date
     * @param fechaHora the date to which the days should be added
     * @param day the number of days to be added
     * @return the formatted string representing the resulting date
     */
    public synchronized String DateSumaDay(String pattern, Date fechaHora, Integer day){
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(funValDate.DateValidador(fechaHora));
            c.add(Calendar.DATE, funValInt.IntegerValidador(day));
            Date crono = c.getTime();
            return parser.format(crono);
        } catch (Exception e) {
            log.error("ERROR | Pattern Vacio: {}",e.getMessage());
            return null;
        }
    }

    /**
     * Adds the specified number of hours to the given date and returns the result as a formatted string.
     *
     * @param pattern the pattern used to format the date
     * @param fechaHora the date to which the hours are added
     * @param horas the number of hours to add
     * @return a formatted string representing the date after adding the specified hours
     */
    public synchronized String DateSumaHour(String pattern, Date fechaHora, Integer horas){
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(funValDate.DateValidador(fechaHora));
            c.add(Calendar.HOUR_OF_DAY, funValInt.IntegerValidador(horas));
            Date crono = c.getTime();
            return parser.format(crono);
        } catch (Exception e) {
            log.error("ERROR | Pattern Vacio: {}",e.getMessage());
            return null;
        }
    }

    /**
     * Adds the specified number of hours to the given date and returns the updated date.
     *
     * @param fechaHora the date to which the hours should be added
     * @param horas the number of hours to add
     * @return the updated date after adding the specified hours
     */
    public synchronized Date DateSumaHour(Date fechaHora, Integer horas){
        Calendar c = Calendar.getInstance();
        c.setTime(funValDate.DateValidador(fechaHora));
        c.add(Calendar.HOUR_OF_DAY, funValInt.IntegerValidador(horas));
        return c.getTime();
    }

    /**
     * Adds the specified number of years to the given date.
     *
     * @param fechaHora the date to which the years are added
     * @param year the number of years to add
     * @return the updated date after adding the years
     */
    public synchronized Date DateSumaYear(Date fechaHora, Integer year){
        Calendar c = Calendar.getInstance();
        c.setTime(funValDate.DateValidador(fechaHora));
        c.add(Calendar.YEAR, funValInt.IntegerValidador(year));
        return c.getTime();
    }

    /**
     * Adds the specified number of years to the given date and returns the result as a formatted string.
     *
     * @param pattern the pattern used to format the date
     * @param fechaHora the date to which the years will be added
     * @param year the number of years to add
     * @return a formatted string representing the date after adding the specified number of years
     */
    public synchronized String DateSumaYear(String pattern, Date fechaHora, Integer year){
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(funValDate.DateValidador(fechaHora));
            c.add(Calendar.YEAR, funValInt.IntegerValidador(year));
            Date crono = c.getTime();
            return parser.format(crono);
        } catch (Exception e) {
            log.error("ERROR | Pattern Vacio: {}",e.getMessage());
            return null;
        }
    }

    /**
     * Adds the specified number of months to the given date and returns the result as a formatted string.
     *
     * @param pattern the pattern used to format the date
     * @param fechaHora the date to which the months should be added
     * @param month the number of months to add
     * @return a formatted string representing the date after adding the specified number of months
     */
    public synchronized String DateSumaMonth(String pattern, Date fechaHora, Integer month){
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(funValDate.DateValidador(fechaHora));
            c.add(Calendar.MONTH, funValInt.IntegerValidador(month));
            Date crono = c.getTime();
            return parser.format(crono);
        } catch (Exception e) {
            log.error("ERROR | Pattern Vacio: {}",e.getMessage());
            return null;
        }
    }

    /**
     * Adds the specified number of months to the given date.
     *
     * @param fechaHora the date to which the months are added
     * @param month     the number of months to add
     * @return the new date after adding the specified number of months
     */
    public synchronized Date DateSumaMonth(Date fechaHora, Integer month){
        Calendar c = Calendar.getInstance();
        c.setTime(funValDate.DateValidador(fechaHora));
        c.add(Calendar.MONTH, funValInt.IntegerValidador(month));
        return c.getTime();
    }

    public synchronized String DateSuma(String pattern, Date fechaHora, Integer day, Integer month, Integer year, Integer hour, Integer minute, Integer second){
        SimpleDateFormat parser = new SimpleDateFormat(funValStr.StringValidador(pattern));

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(funValDate.DateValidador(fechaHora));
            c.add(Calendar.DATE,funValInt.IntegerValidador(day));
            c.add(Calendar.MONTH, funValInt.IntegerValidador(month));
            c.add(Calendar.YEAR, funValInt.IntegerValidador(year));
            c.add(Calendar.HOUR_OF_DAY, funValInt.IntegerValidador(hour));
            c.add(Calendar.MINUTE, funValInt.IntegerValidador(minute));
            c.add(Calendar.SECOND, funValInt.IntegerValidador(second));

            Date crono = c.getTime();
            return parser.format(crono);
        } catch (Exception e) {
            log.error("ERROR | Pattern Vacio: {}",e.getMessage());
            return null;
        }
    }

    public synchronized Date DateSuma(Date fechaHora, Integer day, Integer month, Integer year, Integer hour, Integer minute, Integer second){
        Calendar c = Calendar.getInstance();
        c.setTime(fechaHora);
        c.add(Calendar.DATE, funValInt.IntegerValidador(day));
        c.add(Calendar.MONTH, funValInt.IntegerValidador(month));
        c.add(Calendar.YEAR, funValInt.IntegerValidador(year));
        c.add(Calendar.HOUR_OF_DAY, funValInt.IntegerValidador(hour));
        c.add(Calendar.MINUTE, funValInt.IntegerValidador(minute));
        c.add(Calendar.SECOND, funValInt.IntegerValidador(second));

        return c.getTime();
    }
}