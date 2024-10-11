Respuestas a las Preguntas

    ¿Qué sucede si intentas borrar una encuesta que no existe? ¿Cómo lo has controlado?
        Si se intenta borrar una encuesta que no existe, Spring lanzará una excepción EmptyResultDataAccessException. Para evitar un error de usuario, se puede manejar esta excepción en el controlador usando try-catch o mostrando un mensaje personalizado si la encuesta no fue encontrada.

    Si introduces en un texto del tipo <style>body background-color:red</style> en uno de los campos, ¿qué sucede al ver la encuesta? ¿El navegador ejecuta ese código o no? ¿Por qué? ¿Cómo podrías hacer que se ejecute ese código o que se deje de ejecutar?
        El navegador no ejecuta este código de forma predeterminada si se escapa correctamente al mostrarlo en la plantilla Thymeleaf, usando th:text="${campo}". Esto es porque Thymeleaf escapa el contenido por defecto para evitar inyecciones de código. Para permitir que se ejecute, podrías usar th:utext (no recomendado por seguridad). Para asegurar que no se ejecute, es importante escapar cualquier contenido que pueda provenir de entradas del usuario.

    ¿Qué has tenido que modificar en el repositorio para filtrar por motivo de búsqueda? ¿Has tenido que escribir el código específico o cómo lo has realizado?
        Se añadió un método en el repositorio EncuestaRepository para buscar encuestas por motivo de visita: List<Encuesta> findByMotivoVisita(String motivo);. Luego, se añadió un filtro en el controlador para procesar el parámetro de búsqueda y enviar los resultados a la vista. Este método permite obtener las encuestas que coincidan con el motivo seleccionado y es un código específico escrito para este propósito.
