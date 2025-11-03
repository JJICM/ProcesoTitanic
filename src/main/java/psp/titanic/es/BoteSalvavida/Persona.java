package psp.titanic.es.BoteSalvavida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private int mujeres;
    private int varones;
    private int ninos;
    private int total;
}
