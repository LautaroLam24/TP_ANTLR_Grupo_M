# Intérprete "Simple" con ANTLR4

Trabajo Práctico Cuatrimestral — *Conceptos y Paradigmas de Lenguajes de Programación* (2026)
Licenciatura en Sistemas — UNLa

Intérprete de un lenguaje imperativo simple implementado en **Java 17 + ANTLR 4.13.1**.
El árbol sintáctico generado por ANTLR se recorre con el patrón **Visitor**.

---

## Integrantes

- Lautaro Lamaita
- Marcos Miño

## Variante asignada

**Variante 1 — `while`** (iteración con condición al inicio).

---

## Descripción del lenguaje

`Simple` es un lenguaje imperativo de tipado estático. Un programa tiene la forma:

```
program <nombre> {
    <sentencias>
}
```

### Tipos de datos

| Tipo     | Ejemplo de literal | Representación en Java |
|----------|--------------------|------------------------|
| `int`    | `42`               | `Integer`              |
| `real`   | `3.14`             | `Double`               |
| `string` | `"hola"`           | `String`               |
| `bool`   | `true` / `false`   | `Boolean`              |

### Comentarios

- De línea: `// ...`
- De bloque (multilínea, opcional): `/* ... */`

Ambos se descartan en el análisis léxico.

### Variables

Declaración con tipo obligatorio e inicialización **opcional**:

```
var edad : int;            // declarada, sin inicializar
var pi   : real = 3.14;    // declarada e inicializada
```

- No pueden usarse antes de ser declaradas.
- No pueden redeclararse en el mismo ámbito.
- El tipo del valor debe ser compatible con el de la variable.

### Expresiones

- **Aritméticas:** `+`, `-`, `*`, `/`
- **Relacionales:** `>`, `<`, `>=`, `<=`
- **Igualdad:** `==`, `!=`
- **Lógicas:** `&&`, `||`, `!`
- Paréntesis para agrupar.

Precedencia (de mayor a menor): unarios `- !` → `* /` → `+ -` → relacionales → igualdad → `&&` → `||`.

### Salida

```
print(<expresion>);
```

### Condicional

```
if (<condicion>) {
    ...
} else {        // el else es opcional
    ...
}
```

### Iteración (variante asignada)

```
while (<condicion>) {
    ...
}
```

---

## Reglas de tipos (resumen)

- **Aritmética** (`+ - * /`): operandos numéricos. Si alguno es `real`, el resultado es `real`; si ambos son `int`, el resultado es `int` (la división `/` entre enteros es entera).
- **`+` sobre cadenas**: concatena dos `string`.
- **Relacionales** (`> < >= <=`): operandos numéricos → `bool`.
- **Igualdad** (`== !=`): operandos numéricos entre sí, o del mismo tipo → `bool`.
- **Lógicos** (`&& || !`): operandos `bool` → `bool`.
- **Asignación / inicialización**: el valor debe ser del mismo tipo que la variable, con una única promoción permitida: `int` puede asignarse a una variable `real`.
- **Condición de `if` / `while`**: debe ser `bool`.

---

## Análisis semántico

Antes de ejecutar, una pasada de análisis semántico recorre el árbol y detecta:

1. Uso de variables **no declaradas**.
2. **Redeclaración** de variables (en el mismo ámbito).
3. **Incompatibilidades de tipos** (en declaración, asignación y condiciones).
4. **Operaciones inválidas** (p. ej. sumar `bool`, negar un número, comparar tipos distintos).
5. **División por cero** detectable de forma estática (divisor literal `0`).

Si hay errores semánticos, se reportan **todos juntos** (con número de línea) y el programa **no se ejecuta**.

La división por cero con divisor calculado en tiempo de ejecución, y el uso de una variable declarada pero nunca inicializada, se detectan durante la **ejecución**.

---

## Decisiones de diseño

- **`program <nombre> { ... }`** como envoltura del programa: da un punto de entrada claro y delimita el ámbito global.
- **Dos pasadas separadas** (`SemanticAnalyzer` y luego `Interpreter`), ambas con Visitor. Separar la verificación de la ejecución mantiene cada clase con una sola responsabilidad y permite reportar todos los errores semánticos antes de correr una sola línea.
- **Tabla de símbolos con ámbitos anidados** (`SymbolTable`): una pila de mapas. Cada bloque `{ }` abre y cierra un ámbito. Permite detectar redeclaraciones dentro de un mismo ámbito y resolver variables de ámbitos externos.
- **Tipo `int` asignable a `real`** (promoción), pero no a la inversa, para no perder precisión de forma implícita.
- **`/` entre enteros es división entera**, coherente con el tipo del resultado; con algún operando `real`, es división real.
- **`+` concatena cadenas** además de sumar números.
- **Cortocircuito** en `&&` y `||`.
- **Salida forzada a UTF-8** para que los acentos se vean bien en cualquier consola.
- **Listener de errores propio** que acumula los errores léxicos/sintácticos de ANTLR (en lugar del comportamiento por defecto, que solo imprime en `stderr` y continúa).
- La inicialización de variables es **opcional** en la declaración; el uso de una variable sin inicializar se controla en ejecución.

---

## Estructura del proyecto

```
interprete/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── antlr4/com/miorganizacion/simple/interprete/
    │   │   └── Simple.g4               # gramática (lexer + parser)
    │   └── java/com/miorganizacion/simple/interprete/
    │       ├── Main.java               # punto de entrada / orquestación
    │       ├── Type.java               # enum de tipos
    │       ├── Symbol.java             # entrada de la tabla de símbolos
    │       ├── SymbolTable.java        # tabla de símbolos con ámbitos
    │       ├── SyntaxErrorListener.java# acumula errores léxicos/sintácticos
    │       ├── SemanticAnalyzer.java   # 1ra pasada: chequeo de tipos (Visitor)
    │       ├── Interpreter.java        # 2da pasada: ejecución (Visitor)
    │       └── RuntimeError.java       # errores de tiempo de ejecución
    └── test/resources/                 # programas de ejemplo (.smp)
        ├── 01_tipos_y_expresiones.smp
        ├── 02_if_else.smp
        ├── 03_while.smp
        ├── 04_errores_semanticos.smp
        └── 05_factorial.smp
```

Las clases del lexer/parser/visitor (`SimpleLexer`, `SimpleParser`, `SimpleVisitor`,
`SimpleBaseVisitor`) las **genera ANTLR** a partir de `Simple.g4` durante la compilación
y **no** se incluyen en la entrega.

---

## Compilación y ejecución

### Requisitos
- JDK 17 o superior
- Maven 3.8+

### Compilar (genera el parser con ANTLR y compila todo)

```bash
mvn clean compile
```

### Ejecutar

El archivo a interpretar se define en la variable `path` de `Main.java`. Por
defecto es `src/test/resources/01_tipos_y_expresiones.smp`. Para probar otro
ejemplo, cambiá esa ruta por la del archivo deseado (por ejemplo
`src/test/resources/03_while.smp`) y volvé a ejecutar.

- Desde IntelliJ: botón **Run (▶)** sobre `Main`.
- Desde Maven:

```bash
mvn exec:java
```

### Ejecución sin Maven (opcional)

Si se cuenta con el jar completo de ANTLR (`antlr-4.13.1-complete.jar`), puede
generarse y compilarse a mano:

```bash
# 1) generar parser + visitor (el -package replica lo que hace el plugin de Maven)
java -jar antlr-4.13.1-complete.jar -visitor -no-listener \
     -package com.miorganizacion.simple.interprete \
     -o gen src/main/antlr4/com/miorganizacion/simple/interprete/Simple.g4

# 2) compilar
javac -cp antlr-4.13.1-complete.jar -d out \
     $(find gen -name "*.java") $(find src/main/java -name "*.java")

# 3) ejecutar (usa el archivo definido en Main.java)
java -cp "out:antlr-4.13.1-complete.jar" \
     com.miorganizacion.simple.interprete.Main
```

---

## Ejemplos de uso

### Variante `while` (`03_while.smp`)

```
program bucle_while {
    var i : int = 0;
    while (i < 5) {
        print(i);
        i = i + 1;
    }
}
```

Salida:

```
0
1
2
3
4
```

### Detección de errores (`04_errores_semanticos.smp`)

Salida (extracto):

```
Errores semánticos (7):
  - [línea 7] redeclaración de la variable 'x'
  - [línea 9] variable no declarada: 'y'
  - [línea 11] no se puede inicializar 'z' (int) con un valor de tipo string
  - [línea 16] la operación '+' no es válida entre bool y int
  - [línea 18] división por cero
  - [línea 20] la condición del 'if' debe ser bool, no int
```
