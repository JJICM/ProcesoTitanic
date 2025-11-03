package psp.titanic.es.BoteSalvavida;

public class Bote {

    public static Persona recogerPasajero(final int SOBREVIVIENTE_MAX) {
        int mujeres = (int) (Math.random() * SOBREVIVIENTE_MAX);
        int varones = (int) (Math.random() * (SOBREVIVIENTE_MAX - mujeres));
        int ninos = (int) (Math.random() * (SOBREVIVIENTE_MAX - mujeres - varones));
        int total = mujeres + varones + ninos;
        return new Persona(mujeres, varones, ninos, total);
    }

    public static String devolverPasajero(Persona persona, final String SEPARACION) {
        // Convierte los sobrevivientes en .csv
        StringBuilder informePersona = new StringBuilder();
        informePersona.append(persona.getMujeres()).append(SEPARACION).append(persona.getVarones()).append(SEPARACION)
                .append(persona.getNinos()).append(SEPARACION).append(persona.getTotal());
        return informePersona.toString();
    }
}
