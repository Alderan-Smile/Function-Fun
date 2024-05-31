package DateAndTime;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/******************************************************************************
 * @company Accenture                                                         *
 * @author Oliver Consterla Araya                                             *
 * @version 1.0                                                               *
 * @since 2024                                                                *
 ******************************************************************************/
@Slf4j
public class FunDate {

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

    public synchronized Date DateSuma(Date fechaHora, int dias){
        Calendar c = Calendar.getInstance();
        c.setTime(fechaHora);
        c.add(Calendar.DATE, dias);
        return c.getTime();
    }


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