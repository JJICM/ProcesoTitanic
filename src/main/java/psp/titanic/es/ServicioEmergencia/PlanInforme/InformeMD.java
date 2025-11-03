package psp.titanic.es.ServicioEmergencia.PlanInforme;

public class InformeMD implements DiseñoInforme{

    @Override
    public String crearInforme(String id, String[] sobrevivientes, final String MSG_NO_IMPLEMENTADO) {
        StringBuilder informe = new StringBuilder();
        informe.append("\n").append("## Bote ").append(id).append("\n\n");
        informe.append("- Total Salvados ").append(sobrevivientes[3]).append("\n");
        informe.append("  - Mujeres ").append(sobrevivientes[0]).append("\n");
        informe.append("  - Varones ").append(sobrevivientes[1]).append("\n");
        informe.append("  - Niños ").append(sobrevivientes[2]).append("\n");
        return informe.toString();
    }

}
