
# PROCESOS EN TITANIC

## Índice

1. Análisis

2. Diseño

   1. Arquitectura

   2. Componentes

   3. Protocolo de comunicación

   4. Plan de pruebas

3. Manual de usuario

4. Elementos destacables del desarrollo

5. Problemas encontrados

6. Conclusiones individuales

7. Anexos

## Análisis

Se pide una aplicación **Titanic** donde se gestione un simulador de emergencias en caso del colapso del barco.

Se dispondrá de un **servicio de emergencias** que lanzará **botes salvavidas**, recogiendo a los pasajeros o tripulantes. Solo se disponen de 20 botes en total y cada bote otorgará al servicio de emergencias el informe de los sobrevivientes auxiliados.

Al final, el servicio de emergencias emitirá un informe final con la cantidad de los rescatados.

## Diseño

- ### Arquitectura

  - **ServicioEmergencia**
    - Lanza botes salvavidas
    - Cuenta los sobrevivientes
    - Crea el informe final

  - **BoteSalvavida**
    - Devuelve pasajeros y tripulantes

- ### Componentes

  - **Lanzar bote**
    - Ejecuta el proceso Bote y crea el identificador de cada bote

  - **Contar sobreviviente**
    - Suma la cantidad total de personas sobrevivientes y devuelve el total

  - **Crear informe**
    - Dada la información obtenida, diseña el informe y la crea
      1. Para el **diseño**, se usará una clase abstracta DiseñoInforme, donde se creará la estructura de la misma
      2. Para la **creación**, se usará una clase Informe para el formato del mismo y el día

  - **Devolver pasajero**
    - Obtiene cantidades de Persona de manera aleatoria y suma el total
      - Persona tiene mujeres, varones y niños

- ### Protocolo de comunicación

1. ServicioEmergencia ejecuta Bote (xCantidad)

2. BoteSalvavida devuelve un array de números al ServicioEmergencia y este suma el total (xCantidad)

3. ServicioEmergencia pasa los datos de los sobrevivientes y el identificador del bote a Informe (xCantidad)

4. Informe crea el informe

- ### Plan de pruebas

Probar que lanzarBote() se lance correctamente y que el número de botes disminuya

Probar que contarSobrevivientes() funcione y que cuente de forma correcta

Probar que generarInforme() genere correctamente el informe

Probar que devolverPasajero() devuelva un número correcto

## Manual de usuario

En VSCode, ejecutar **MainServicioEmergencia.java**.

## Elementos destacables del desarrollo

La aplicación no compila con ```mvn compile```, debido a los constructores.

## Problemas encontrados

1. Problema con la galería Lombok

Error de código, alertaba como error al usar el constructor de Persona. Comprobé la compatibilidad de versiones entre el jdk y lombok. La solución final fué dejar de usar la máquina virtual Linux y clonar el repositorio de Github a la máquina real.

2. Problema con el método recogerPasajero()

El randomizador de números tiene el porcentaje mal distribuido. Una posible solución es un do-while.
```java
public static Persona recogerPasajero() {
  do {
    int mujeres = (int)(Math.random() * 101);
    int varones = (int)(Math.random() * 101);
    int ninos = (int)(Math.random() * 101);
  } while (a + b + c > 100);
  return new Persona(mujeres, varones, ninos);
}
```
Pero es muy poco eficiente.

3. Problema con el método contarSobreviviente()

Al intentar convertir el último String de los sobrevivientes, daba NumberFormatException. La solución fué usar el método .trim() para quitar los espaciados.

## Conclusiones individuales

En futuras versiones o proyectos mejorar las pruebas unitarias y/o con mockito.

## Anexos

**Informe de sobrevivientes:** [Ver el informe final](doc/Informe.md)

**Repositorio de github:** https://github.com/JJICM/ProcesoTitanic.git
