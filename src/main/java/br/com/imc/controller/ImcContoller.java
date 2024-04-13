package br.com.imc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.imc.model.Usuario;
import br.com.imc.repository.UsuarioRepository;

@Controller
public class ImcContoller {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/listatodos")
	ResponseEntity<List<Usuario>>Todos(){
		
		List<Usuario> lista = usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(lista,HttpStatus.OK);
	}
	
	
	@ResponseBody
	@PostMapping(value = "/salvar")	
	ResponseEntity <Usuario>salvar(@RequestBody Usuario usuario){
		Usuario user = usuarioRepository.save(usuario);

		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		
	}
	@ResponseBody
	@DeleteMapping(value = "/delete")
	ResponseEntity<String>delete(@RequestParam Long iduser){
		
		usuarioRepository.findById(iduser);
		
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
		
		
		
	}
	
	
	@GetMapping(value = "/buscarPorNome") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(name = "name") String name) { /* Recebe os dados para consultar */

		List<Usuario> usuario = usuarioRepository.buscarPorNome(name.trim().toUpperCase());

		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/buscaruserid") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<Usuario> buscaruserid(@RequestParam(name = "iduser") Long iduser) { /* Recebe os dados para consultar */

		Usuario usuario = usuarioRepository.findById(iduser).get();

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}
	
	
	
	@ResponseBody
	@PutMapping(value = "/atualizar")	
	ResponseEntity <?>atualizar(@RequestBody Usuario usuario){
		if (usuario.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualização.", HttpStatus.OK);
		}

		Usuario user = usuarioRepository.saveAndFlush(usuario);

		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

}