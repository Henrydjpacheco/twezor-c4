package twezor.mensajes.repository;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import twezor.mensajes.model.Mensaje;

public interface MensajeRepository extends MongoRepository<Mensaje, ObjectId> {
    List<Mensaje> findAllByRemitenteAndReceptor(String id_remitente, String id_receptor);
}
