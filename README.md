# Music

Music es un reproductor Android para uso personal, basado en código abierto de [InterTune](https://github.com/ItzSkyeYT/InterTune) y [OuterTune](https://github.com/OuterTune/OuterTune), ambos bajo GPL-3.0. No está afiliado con YouTube, Google ni los autores originales.

## Funciones

- Buscar música del catálogo de YouTube Music y reproducir en línea.
- Mezclas personales que aprenden de tus favoritos, reproducciones y canciones que saltas.
- Reproducción en segundo plano, notificación multimedia y controles desde la pantalla de bloqueo.
- Letras sincronizadas cuando una fuente disponible tiene coincidencia. Fuentes incluidas: LRCLIB, KuGou, subtítulos de YouTube y Better Lyrics.
- **Ecos**: guarda una frase sincronizada con una nota personal y vuelve a ese instante; queda en el teléfono.
- Descargas/caché para escuchar sin conexión dentro de Music.
- Android Auto: navegación, búsqueda, cola y controles multimedia.
- Ecualizador y ajustes de calidad de audio, reproducción, biblioteca y batería.
- Interfaz oscura con acento verde, tipografía Manrope y efecto Liquid Glass/transparencia activado al inicio; puede desactivarse en Ajustes.
- Las letras también pueden convertirse en una tarjeta o video corto sincronizado para compartir.
- Sin anuncios añadidos por Music. El servicio de catálogo es no oficial y puede cambiar o dejar de funcionar.

Las imágenes de `design-preview/` son maquetas conceptuales, no capturas de una APK ejecutándose: [Inicio](design-preview/music-home.png), [letras y Ecos](design-preview/music-lyrics.png), [lista de Ecos](design-preview/music-ecos.png) y [Android Auto](design-preview/music-auto.png).

La disponibilidad de letras y canciones depende de las fuentes remotas. Las descargas son para reproducción dentro de la app y siguen sujetas a las condiciones de los proveedores; no convierten el catálogo en archivos libres de derechos.

## Compilar

Requiere JDK 21 y Android SDK 36. En Windows:

```powershell
.\gradlew.bat assembleCoreDebug
```

El APK se genera en `app/build/outputs/apk/core/debug/`. La variante `coreDebug` se firma con la clave de depuración local y activa las pantallas de Android Auto.

Para una instalación hecha desde APK, Android Auto puede ocultar Music. En el teléfono, abre los ajustes de Android Auto, toca diez veces «Versión», entra en «Configuración para desarrolladores» y habilita «Fuentes desconocidas».

## Licencia y soporte

El proyecto conserva la licencia GPL-3.0 y los avisos de derechos de autor de las obras originales. La fuente correspondiente a esta compilación está incluida en este proyecto. Consulta `LICENSE` y la pantalla «Atribuciones» de la app para los créditos y licencias de dependencias.

Esta copia es personal y no tiene soporte de los autores de InterTune u OuterTune. Para reportar un problema de esta compilación, vuelve a la conversación de Codex donde recibiste el proyecto.

Manrope se distribuye bajo SIL Open Font License 1.1; su licencia está en `THIRD_PARTY_LICENSES/Manrope-OFL.txt`.
