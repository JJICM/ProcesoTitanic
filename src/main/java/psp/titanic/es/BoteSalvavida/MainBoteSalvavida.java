package psp.titanic.es.BoteSalvavida;

public class MainBoteSalvavida {

    final static String SEPARACION = ",";

    public static void main(String[] args) {
        System.out.println(Bote.devolverPasajero(Bote.recogerPasajero(), SEPARACION));
    }
}
