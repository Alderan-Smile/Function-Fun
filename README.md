# Function_Fun
Dependencia Maven personal para facilitar el uso de funciones nuevas y antiguas.

## ¿Como usar?

Primero se debe agregar la dependencia al pom.xml

    <dependency>
        <groupId>io.github.alderan-smile</groupId>
        <artifactId>function_fun</artifactId>
        <version>0.0.1</version>
    </dependency>

Luego se debe importar la clase `FunctionFun` y se podrá usar las funciones que se encuentran en ella declarándola.

    import function_fun.DateAndTime.FunDate;
    public class Main {
        FunDate funDate = new FunDate();
    }

# Funciones

## FunDate
A continuación se presentan las funciones de la clase `FunDate`:

### StringToDate
Convierte un String en un objeto Date.

    public static Date StringToDate(String pattern, String fechaHora)

### DateToString
Convierte un objeto Date en un String.

    public static String DateToString(String pattern, Date fechaHora)

### DateSuma
Suma una cantidad de tiempo a un objeto Date y lo mantiene como Date o convierte a String segun sea necesario.

    public static String DateSuma(String pattern, Date fechaHora, int dias)
o

    public static Date DateSuma(Date fechaHora, int dias)

Mientras más funciones se vayan agregando se irán documentando en este archivo o creando alguna subwiki.
>Version 0.0.1 31/05/2024