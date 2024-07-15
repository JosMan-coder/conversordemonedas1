# conversordemonedas

Mi conversor de monedas

Este es un programa en Java que convierte diferentes monedas utilizando la API de ExchangeRate-API. El programa permite convertir entre las siguientes monedas:

- Dólar a Peso Mexicano
- Peso Mexicano a Dólar
- Dólar a Peso Colombiano
- Peso Colombiano a Dólar
- Dólar a Real Brasileño
- Real Brasileño a Dólar
- Dólar a Peso Argentino
- Peso Argentino a Dólar

## Requisitos

- Java 8 o superior
- IntelliJ IDEA (opcional, pero recomendado)
- Dependencias de Maven:
  - `com.squareup.okhttp3:okhttp:4.9.3`
  - `com.google.code.gson:gson:2.8.8`

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tuusuario/conversor-de-monedas.git
    cd conversor-de-monedas
    ```

2. Importa el proyecto en IntelliJ IDEA (opcional).

3. Asegúrate de que las dependencias de Maven estén correctamente configuradas en tu archivo `pom.xml`.

4. Obtén tu clave API de [ExchangeRate-API](https://www.exchangerate-api.com/) y reemplaza `API_KEY` en el archivo `Main.java` con tu clave API.

## Uso

1. Ejecuta la clase `Main` en tu IDE o en la línea de comandos:
    ```sh
    javac -cp src/main/java src/main/java/com/conversordemonedas/Main.java
    java -cp src/main/java com.conversordemonedas.Main
    ```

2. Sigue las instrucciones en el menú para convertir entre las diferentes monedas.
