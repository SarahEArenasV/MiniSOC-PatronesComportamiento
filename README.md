# Parcial 3 - Programación II

Sistema por consola de monitoreo de seguridad de red **MiniSOC**, implementado en Java con 8 patrones de diseño de comportamiento.

## Integrantes

- Sarah Elizabeth Arenas Vanegas
- Juan Pablo Velandia Barragan

## Patrones implementados

### Bloque Base

| Requerimiento | Patrón | Paquete |
|---|---|---|
| Notificación de cambios en las alertas | Observer | `observer` |
| Cálculo del riesgo por severidad o frecuencia | Strategy | `strategy` |
| Acciones de respuesta con deshacer | Command | `command` |
| Ciclo de vida de la alerta | State | `state` |
| Coordinación entre IDS, firewall, antivirus y analista | Mediator | `mediator` |

### Bloque Investigativo

| Requerimiento | Patrón | Paquete |
|---|---|---|
| Filtrado del tráfico (lista blanca, firmas, heurística) | Chain of Responsibility | `chainofresponsibility` |
| Recorrido de los logs de red | Iterator | `iterator` |
| Respaldo y restauración de la configuración del firewall | Memento | `memento` |
