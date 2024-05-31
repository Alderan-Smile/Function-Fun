package DateAndTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/******************************************************************************
 * @company Accenture                                                         *
 * @author Oliver Consterla Araya                                             *
 * @version 1.0                                                               *
 * @since 2024                                                                *
 ******************************************************************************/
public class FunDate {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunDate.class.getName());

    public synchronized Date parsero(SimpleDateFormat parser, String hora){
        try{
            Date trono = parser.parse(hora);
            return trono;
        } catch (ParseException e) {
            LOGGER.info("ERROR | Error Parse en: "+e);
            return null;
        }
    }
}