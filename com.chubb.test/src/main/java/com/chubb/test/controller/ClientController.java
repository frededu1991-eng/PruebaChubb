package com.chubb.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chubb.test.model.dtos.ClientDto;
import com.chubb.test.model.dtos.ServiceResponse;
import com.chubb.test.service.IClientService;

@RestController
@CrossOrigin(origins = { "http://localhost:8080" })
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private IClientService clientService;
	
	@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getClients() {
    	return ResponseEntity.ok(clientService.findAll());
    	
    }

	@CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/client")
    public ResponseEntity<ServiceResponse> saveClient(@RequestBody ClientDto client) {
    	ServiceResponse serviceReponse = new ServiceResponse();
    	int result = clientService.save(client);
    	if (result == 1) {
    		serviceReponse.setSuccess(true);
	    	serviceReponse.setMessage("Client saved with sucesss");
    	}
    	
    	return new ResponseEntity<>(serviceReponse, HttpStatus.OK);
    	
    }

	 @DeleteMapping("/clientes/{id}")
    @Operation(
        summary = "Eliminar un cliente por ID", 
        description = "Elimina permanentemente un cliente del sistema. Retorna 204 si tiene éxito o 404 si el ID no existe."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente eliminado correctamente (No Content)"),
        @ApiResponse(responseCode = "404", description = "El cliente no existe (Not Found)")
    })
    public ResponseEntity<Void> eliminarCliente(
            @Parameter(description = "ID único del cliente a eliminar", required = true, example = "1")
            @PathVariable Long id) {
        
        // 1. Validar la existencia del cliente utilizando el servicio
        boolean existe = clienteService.existeCliente(id);
        
        if (!existe) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
	}
	
}
