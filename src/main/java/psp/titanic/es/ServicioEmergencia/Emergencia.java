package psp.titanic.es.ServicioEmergencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Emergencia {

    private int sobrevivienteTotal = 0;

    public String lanzarBote(final String[] COMANDO, final String MSG_ERROR, final int ESPERA_MAX,
            final int ESPERA_MIN) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(COMANDO);

        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        Thread.sleep((int) (Math.random()) * (ESPERA_MAX - ESPERA_MIN + 1) + ESPERA_MAX);
        int exitVal = process.waitFor();
        if (exitVal != 0) {
            return MSG_ERROR;
        }

        return output.toString();
    }

    public void contarSobreviviente(String informePersona) {
        String[] sobrevivientes = informePersona.split(",");
        int total = Integer.parseInt(sobrevivientes[sobrevivientes.length - 1]);
        sobrevivienteTotal += total;
    }

}
