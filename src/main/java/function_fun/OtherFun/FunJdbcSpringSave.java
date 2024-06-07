package function_fun.OtherFun;

import java.util.List;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202467.0.21                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/

public interface FunJdbcSpringSave {

    /**
     * This method is used to save an object and its related object into the database.
     *
     * @param <T> This is the type of the main object to be saved.
     * @param <R> This is the type of the related object to be saved.
     * @param obj This is the main object to be saved.
     * @param obj2 This is the related object to be saved.
     */
    <T, R> void save(T obj, R obj2);

    /**
     * This method is used to save a list of objects into the database.
     *
     * @param <T> This is the type of the objects in the list to be saved.
     * @param list This is the list of objects to be saved.
     */
    <T, R> void saveAll(List<T> list);
}
