package twezor.mensajes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MensajeDto {
    
    @JsonProperty("remitente")
    private Integer remitente;
    
    @JsonProperty("receptor")
    private Integer receptor;
    
    @JsonProperty("contenido")
    private String contenido;
    
    @JsonProperty("hora_creacion")
    private String hora_creacion;
    
    
}
