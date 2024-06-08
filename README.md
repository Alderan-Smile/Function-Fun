# Function_Fun
Dependencia Maven personal para facilitar el uso de funciones nuevas y antiguas.

## ¿Como usar?

Primero se debe agregar la dependencia al pom.xml

    <dependency>
        <groupId>io.github.alderan-smile</groupId>
        <artifactId>function_fun</artifactId>
        <version>0.1.2</version>
    </dependency>

Luego se debe importar la clase `FunctionFun` y se podrá usar las funciones que se encuentran en ella declarándola.

    import function_fun.DateAndTime.FunDate;
    public class Main {
        FunDate funDate = new FunDate();
    }

# Funciones por carpetas

## function_fun.DateAndTime
Esta carpeta tiene funciones correspondientes a la manipulacion de Date y su conversion a String.

## function_fun.OtherFun
Aqui se encontraran funcionalidades que no tengan categoria propia correspondiente o que solo tendran 1 tipo de funcionalidad

## function_fun.SuitJdbcSpring
Aqui se encontraran funcionalidades y anotaciones perfectas para usar Spring JDBC con save() y saveAll(), emulando las funcionalidades de JPA.

## function_fun.ValidadorMaxMinEqual
Aqui se encontraran validadores de valores maximos, minimos o iguales segun sea conveniente.

## function_fun.VoidNullValidador
Aqui podras encontrar validadores especiales para distintos tipos de datos/variables.

### Para mayor informacion pueden visitar la [wiki](https://github.com/Alderan-Smile/function_fun/wiki) de la dependencia