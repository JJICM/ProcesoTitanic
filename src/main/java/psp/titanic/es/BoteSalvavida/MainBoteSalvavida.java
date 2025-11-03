package psp.titanic.es.BoteSalvavida;

public class MainBoteSalvavida {

    final static String SEPARACION = ",";
    final static int SOBREVIVIENTE_MAX = 101;

    public static void main(String[] args) {
        System.out.println(Bote.devolverPasajero(Bote.recogerPasajero(SOBREVIVIENTE_MAX), SEPARACION));
    }
}
