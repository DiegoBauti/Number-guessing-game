# Number Guessing Game

Un juego de adivinanza de números basado en CLI construido en Java donde los jugadores intentan adivinar un número generado aleatoriamente dentro de un número limitado de intentos.

## Descripción

Este es un juego interactivo de línea de comandos donde la computadora selecciona aleatoriamente un número entre 1 y 100, y el jugador debe adivinarlo. El juego cuenta con múltiples niveles de dificultad y rastrea tus mejores puntajes entre sesiones.

## Características

- **Tres niveles de dificultad**:
  - Fácil: 10 intentos
  - Medio: 5 intentos
  - Difícil: 3 intentos

- **Pistas inteligentes**: Después de cada intento, el juego te dice si el número objetivo es mayor o menor

- **Seguimiento de récords**: El juego guarda tu mejor rendimiento (menor cantidad de intentos) para cada nivel de dificultad

- **Múltiples rondas**: Juega tantas veces como quieras sin reiniciar el programa

- **Almacenamiento persistente**: Los puntajes altos se guardan en un archivo y persisten entre sesiones de juego

- **Temporizador**: Mide cuánto tiempo tardas en adivinar el número

- **Sistema de récords**: Te notifica cuando estableces un nuevo récord personal

## Requisitos previos

- Java 11 o superior
- Una terminal o línea de comandos

## Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/DiegoBauti/Number-guessing-game.git
cd guess-the-number
```

2. Compila el proyecto:
```bash
javac *.java
```

3. Ejecuta el juego:
```bash
java Main
```

## Cómo jugar

1. Cuando el juego inicia, selecciona tu nivel de dificultad (1-3)
2. Ingresa tu suposición cuando se te solicite
3. Sigue las pistas (mayor/menor) para reducir tus opciones
4. Después de cada intento, elige si deseas continuar jugando o salir
5. Intenta adivinar el número en la menor cantidad de intentos posible

## Ejemplo de juego
```
Welcome to the Number Guessing Game!
I'm thinking of a number between 1 and 100.

Please select the difficulty level:
1. Easy (10 chances)
2. Medium (5 chances)
3. Hard (3 chances)

Enter your choice: 2

Great! You have selected the medium difficulty level.
Let's start the game!

Enter your guess: 12
Incorrect! The number is less than 12.
Remaining attempts: 4
Do you want to continue playing? (y/n): y

Enter your guess: 5
Incorrect! The number is less than 5.
Remaining attempts: 3
Do you want to continue playing? (y/n): y

Enter your guess: 1
Incorrect! The number is greater than 1.
Remaining attempts: 2
Do you want to continue playing? (y/n): y

Enter your guess: 3
Congratulations! You guessed the correct number in 4 attempts.
You took 38 seg.
New record! Previous best: 5 attempts
```
