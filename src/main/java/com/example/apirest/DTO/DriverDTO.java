package com.example.apirest.DTO;

    // La clase para el DTO debería ser lo más simple posible, sólo con los datos que
    // queramos entregar al cliente. En este caso sólo exponemos el código y el nombre.


public record DriverDTO(
        String code,
        String name  // El name se forma concatenando el forename y el surname en el DriverDTOMapper

) {}
