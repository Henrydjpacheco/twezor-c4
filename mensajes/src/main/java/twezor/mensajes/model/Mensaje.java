package twezor.mensajes.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "mensaje")
@Getter
@Setter
public class Mensaje {
    
    @Id
    private String id;
    
    @Field(name = "remitente")
    private String remitente;
    
    @Field(name = "receptor")
    private String receptor;
    
    @Field(name = "contenido")
    private String contenido;
    
    @Field(name = "hora_creacion", targetType = FieldType.DATE_TIME)
    private Date hora_creacion;

    public Mensaje() {}

    public Mensaje(String id_remitente, String id_receptor, String contenido, Date hora_creacion) {
        this.remitente = id_remitente;
        this.receptor = id_receptor;
        this.contenido = contenido;
        this.hora_creacion = hora_creacion;
    }
    
}
