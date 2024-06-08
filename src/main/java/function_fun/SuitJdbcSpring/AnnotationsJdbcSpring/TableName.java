package function_fun.SuitJdbcSpring.AnnotationsJdbcSpring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202466.22.43                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableName {
    String value();
}
