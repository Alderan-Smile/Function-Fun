package function_fun.AnnotationsJdbcSpring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202466.22.27                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnName {
    String value();
}
