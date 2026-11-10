
package com.modaurbana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {

    private static final String HOST =
            System.getenv().getOrDefault("DB_HOST", "db");

    private static final String URL =
            "jdbc:mysql://" + HOST + ":3306/moda_urbana"
            + "?useSSL=false&allowPublicKeyRetrieval=true"
            + "&serverTimezone=UTC";

    private static final String USUARIO =
            System.getenv().getOrDefault("DB_USER", "moda_user");

    private static final String PASSWORD =
            System.getenv().getOrDefault("DB_PASSWORD", "moda_pass");

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       MODA URBANA");
        System.out.println("================================");

        for (int intento = 1; intento <= 30; intento++) {

            try (Connection conexion =
                    DriverManager.getConnection(URL, USUARIO, PASSWORD)) {

                System.out.println("Conexion exitosa con MySQL.");

                Statement consulta = conexion.createStatement();

                ResultSet resultado = consulta.executeQuery("SELECT 1");

                if (resultado.next()) {
                    System.out.println(
                            "Respuesta de MySQL: " + resultado.getInt(1));
                }

                resultado.close();
                consulta.close();

                System.out.println("Los contenedores se comunican correctamente.");
                return;

            } catch (Exception e) {

                System.out.println(
                        "Intento " + intento + ": esperando MySQL...");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        System.out.println("No fue posible conectar con MySQL.");
    }
}
