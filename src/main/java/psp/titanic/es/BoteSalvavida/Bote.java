package psp.titanic.es.BoteSalvavida;

public class Bote {

    public static Persona recogerPasajero() {
        int mujeres = (int) (Math.random() * 101);
        int varones = (int) (Math.random() * (101 - mujeres));
        int ninos = (int) (Math.random() * (101 - mujeres - varones));
        int total = mujeres + varones + ninos;
        return new Persona(mujeres, varones, ninos, total);
    }

    public static String devolverPasajero(Persona persona, final String SEPARACION) {
        // Convierte los sobrevivientes en .csv
        StringBuilder informePersona = new StringBuilder();
        informePersona.append(persona.getMujeres()).append(SEPARACION).append(persona.getVarones()).append(SEPARACION)
                .append(persona.getNinos()).append(SEPARACION).append(persona.total);
        return informePersona.toString();
    }
}
