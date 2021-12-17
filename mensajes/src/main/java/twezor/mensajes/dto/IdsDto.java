package twezor.mensajes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IdsDto {
    
    @JsonProperty("id_remitente")
    private Integer id_remitente;
    
    @JsonProperty("id_receptor")
    private Integer id_receptor;
}
