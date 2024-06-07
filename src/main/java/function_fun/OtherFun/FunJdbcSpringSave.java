package function_fun.OtherFun;

import function_fun.AnnotationsJdbcSpring.ColumnName;
import function_fun.AnnotationsJdbcSpring.PrimaryKey;
import function_fun.AnnotationsJdbcSpring.TableName;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.lang.reflect.Field;
import java.lang.IllegalAccessException;

import java.util.List;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202466.21.47                                                                                    *
 * @since 2024                                                                                              *
 ************************************************************************************************************/

public class FunJdbcSpringSave {

    private JdbcTemplate jdbcTemplate;

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

    public <T,R> void saveAll(List<T> list){
        for (T obj : list) {
            R obj2 = getPrimaryKey(obj);
            save(obj, obj2);
        }
    }

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