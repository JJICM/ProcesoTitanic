package psp.titanic.es.BoteSalvavida;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoteTest {

    @Test
    void testDevolverPasajero() {
        Persona persona = new Persona(12, 15, 4, 31);
        String informePersona = Bote.devolverPasajero(persona, ",");

        assertEquals("12,15,4,31", informePersona);
    }

}
