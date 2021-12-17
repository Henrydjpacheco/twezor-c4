package twezor.mensajes.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twezor.mensajes.dto.IdsDto;
import twezor.mensajes.dto.MensajeDto;
import twezor.mensajes.model.Mensaje;
import twezor.mensajes.repository.MensajeRepository;

@Service
public class MensajeService {
    
    @Autowired
    private MensajeRepository mensajeRepository;
    
    public Boolean registarMensaje(MensajeDto mensajeDto) {
        Mensaje mensaje = new Mensaje();
        mensaje.setRemitente(mensajeDto.getRemitente().toString());
        mensaje.setReceptor(mensajeDto.getReceptor().toString());
        mensaje.setContenido(mensajeDto.getContenido());
        mensaje.setHora_creacion(new Date(mensajeDto.getHora_creacion()));
        try {
            mensajeRepository.save(mensaje);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public List<Mensaje> obtenerMensajes(IdsDto ids) {
        return mensajeRepository.findAllByRemitenteAndReceptor(ids.getId_remitente().toString(), ids.getId_receptor().toString());
    }
}
