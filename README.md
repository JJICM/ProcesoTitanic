
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

## Elementos destacables del desarrollo

## Problemas encontrados

## Conclusiones individuales

## Anexos
