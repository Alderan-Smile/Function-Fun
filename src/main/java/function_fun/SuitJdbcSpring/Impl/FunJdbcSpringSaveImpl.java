package function_fun.SuitJdbcSpring.Impl;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import function_fun.SuitJdbcSpring.FunJdbcSpringSave;
import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.ColumnName;
import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.PrimaryKey;
import function_fun.SuitJdbcSpring.AnnotationsJdbcSpring.TableName;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202467.0.44                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
public class FunJdbcSpringSaveImpl implements FunJdbcSpringSave {

    /**
     * The JdbcTemplate instance used for database operations.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor for the FunJdbcSpringSaveImpl class.
     * It initializes the jdbcTemplate instance variable with the provided JdbcTemplate object.
     *
     * @param jdbcTemplate This is the JdbcTemplate object to be used for database operations.
     */
    public FunJdbcSpringSaveImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * This method is used to save an object and its related object into the database.
     * It first creates a NamedParameterJdbcTemplate from the existing JdbcTemplate.
     * Then it creates a BeanPropertySqlParameterSource from the object to be saved.
     * It retrieves the table name from the TableName annotation of the object's class.
     * It then builds the column names and values for the SQL statements from the ColumnName annotations of the object's fields.
     * It creates an INSERT SQL statement and an UPDATE SQL statement.
     * The UPDATE SQL statement includes a WHERE clause built from the ColumnName annotations of the related object's fields.
     * It then tries to execute the UPDATE SQL statement.
     * If no rows are affected (which throws an EmptyResultDataAccessException), it executes the INSERT SQL statement.
     *
     * @param <T> This is the type of the main object to be saved.
     * @param <R> This is the type of the related object to be saved.
     * @param obj This is the main object to be saved.
     * @param obj2 This is the related object to be saved.
     */
    @Override
    public <T,R> void save(T obj, R obj2){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(obj);

        TableName tableNameAnnotation = obj.getClass().getAnnotation(TableName.class);
        String tableName = tableNameAnnotation.value();

        StringBuilder columnNames = new StringBuilder();
        StringBuilder columnValues = new StringBuilder();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            ColumnName annotation = field.getAnnotation(ColumnName.class);
            if (annotation != null) {
                String columnName = annotation.value();
                columnNames.append(columnName).append(", ");
                columnValues.append(":").append(field.getName()).append(", ");
            }
        }

        Field[] fields3 = obj2.getClass().getDeclaredFields();
        for (Field field : fields3) {
            ColumnName annotation = field.getAnnotation(ColumnName.class);
            if (annotation != null) {
                String columnName = annotation.value();
                columnNames.append(columnName).append(", ");
                columnValues.append(":").append(field.getName()).append(", ");
            }
        }

        String insertSql = "INSERT INTO " + tableName + " ("
                + columnNames.substring(0, columnNames.length() - 2) + ") VALUES ("
                + columnValues.substring(0, columnValues.length() - 2) + ")";

        String updateSql = "UPDATE " + tableName + " SET ";
        for (Field field : fields) {
            ColumnName annotation = field.getAnnotation(ColumnName.class);
            if (annotation != null) {
                String columnName = annotation.value();
                updateSql += columnName + " = :" + field.getName() + ", ";
            }
        }

        Field[] fields2 = obj2.getClass().getDeclaredFields();
        int fieldCount = fields2.length;
        updateSql = updateSql.substring(0, updateSql.length() - 2) + " WHERE ";
        for (int i = 0; i < fieldCount; i++) {
            Field field = fields2[i];
            ColumnName annotation = field.getAnnotation(ColumnName.class);
            if (annotation != null) {
                String columnName = annotation.value();
                updateSql += columnName + " = :" + field.getName();
                if (i < fieldCount - 1) {
                    updateSql += " AND ";
                }
            }
        }

        try {
            namedParameterJdbcTemplate.update(updateSql, beanPropertySqlParameterSource);
        } catch (EmptyResultDataAccessException e) {
            namedParameterJdbcTemplate.update(insertSql, beanPropertySqlParameterSource);
        }
    }

    /**
     * This method is used to save a list of objects and their related objects into the database.
     * It iterates over each object in the list, retrieves its primary key using the getPrimaryKey method,
     * and then saves the object and its related object using the save method.
     *
     * @param <T> This is the type of the objects in the list to be saved.
     * @param <R> This is the type of the related objects to be saved.
     * @param list This is the list of objects to be saved.
     */
    @Override
    public <T,R> void saveAll(List<T> list){
        for (T obj : list) {
            R obj2 = getPrimaryKey(obj);
            save(obj, obj2);
        }
    }

    /**
     * This method is used to retrieve the primary key of an object.
     * It iterates over each field of the object's class.
     * If a field has the PrimaryKey annotation, it makes the field accessible,
     * retrieves the value of the field from the object, and returns it as the primary key.
     * If no field has the PrimaryKey annotation, it throws a RuntimeException.
     *
     * @param <T> This is the type of the object.
     * @param <R> This is the type of the primary key.
     * @param obj This is the object.
     * @return The primary key of the object.
     */
    private <T,R> R getPrimaryKey(T obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(PrimaryKey.class) != null) {
                try {
                    field.setAccessible(true);
                    R obj2 = (R) field.get(obj);
                    return obj2;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error al obtener la llave primaria: " + e.getMessage());
                }
            }
        }
        throw new RuntimeException("No se encontró una llave primaria en la clase: " + obj.getClass().getName());
    }
}