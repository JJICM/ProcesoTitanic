package psp.titanic.es.ServicioEmergencia;

import java.io.IOException;

import psp.titanic.es.ServicioEmergencia.PlanInforme.DiseñoInforme;
import psp.titanic.es.ServicioEmergencia.PlanInforme.Informe;
import psp.titanic.es.ServicioEmergencia.PlanInforme.InformeMD;

public class MainServicioEmergencia {

    final static int SOBREVIVIENTE_INICIAL = 0;
    final static String[] CMD = { "java", "-cp", "target/classes", "psp.titanic.es.BoteSalvavida.MainBoteSalvavida" };
    final static String MSG_ERROR = "El proceso ha fallado";
    final static String MSG_NO_IMPLEMENTADO = "Método no implementado";
    final static int ESPERA_MAX = 6000;
    final static int ESPERA_MIN = 2000;
    final static int NUMERO_PROCESO_MAX = 20;
    final static String NOMBRE_BOTE = "B";
    final static String RUTA_INFORME = "doc/Informe.md";

    public static void main(String[] args) {
        Emergencia emergencia = new Emergencia(SOBREVIVIENTE_INICIAL);
        DiseñoInforme diseñoInforme = new InformeMD();
        Informe informe = new Informe("");
        try {
            for (int i = 0; i < NUMERO_PROCESO_MAX; i++) {
                //Lanza bote
                String informePersona = emergencia.lanzarBote(CMD, MSG_ERROR, ESPERA_MAX, ESPERA_MIN);
                //Suma los sobrevivientes
                emergencia.contarSobreviviente(emergencia.contarPersona(informePersona));

                String id = String.format(NOMBRE_BOTE + "%02d", i);
                //Desarrolla la estructura del informe
                String supervivientes = diseñoInforme.crearInforme(id, emergencia.contarPersona(informePersona),
                        MSG_NO_IMPLEMENTADO);
                informe.escribirInforme(supervivientes);
            }
            //Crea el informe
            informe.crearInformeFinal(RUTA_INFORME, emergencia.getSobrevivienteTotal());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}