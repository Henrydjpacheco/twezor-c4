package twezor.mensajes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twezor.mensajes.dto.IdsDto;
import twezor.mensajes.dto.MensajeDto;
import twezor.mensajes.model.Mensaje;
import twezor.mensajes.service.MensajeService;

@RestController
@RequestMapping("/chat")
public class MensajesController {
    
    @Autowired
    private MensajeService mensajeService;
    
    @PostMapping("/sala")
    public Boolean registrarMensaje(@RequestBody MensajeDto mensaje) {
        return mensajeService.registarMensaje(mensaje);
    }
    
    @GetMapping("/sala")
    public List<Mensaje> buscarMensajes(@RequestParam(name="idRemitente") Integer idRemitente,
            @RequestParam(name="idReceptor") Integer  idReceptor){
        IdsDto ids=new IdsDto();
        ids.setId_receptor(idReceptor);
        ids.setId_remitente(idRemitente);
        return mensajeService.obtenerMensajes(ids);
    }
}
