package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDto;
import com.example.demo.service.SecurityService;

@RestController
public class SecurityController {
	
	@RestController
	@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
	@RequestMapping(path = "api/v1/login")
	public class UnidadMedidaController{
		
		@Autowired (required = true)
		protected SecurityService service;
		
		//getAll-----------------------
		
		@GetMapping("/")
		@Transactional
		public ResponseEntity getAll (){
			try {
				return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
				
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
			}
		}
		
		//getOne-----------------------
		
		@GetMapping("/{uid}")
		@Transactional
		public ResponseEntity getOne(@PathVariable String uid) {

			try {

				return ResponseEntity.status(HttpStatus.OK).body(service.findByUid(uid));

			} catch (Exception e) {

				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("{\"Mi mensaje get uno\": \"" + e.getMessage() + "\"}");

			}

		}
		
		
		//post-----------------------
		
		@PostMapping("/")

		@Transactional
		public ResponseEntity post(@RequestBody UserDto dto) {
			
			try {
				

				return ResponseEntity.status(HttpStatus.OK).body(service.save(dto, true));
				
			} catch (Exception e) {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
			("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
							
			}
			
		}
		
	
		
		@PutMapping("/{id}")

		@Transactional
		public ResponseEntity put(@PathVariable String uid, @RequestBody UserDto dto) {
			
			try {
				
				
				return ResponseEntity.status(HttpStatus.OK).body(service.update(uid, dto, true));
				
			} catch (Exception e) {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
						("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
							
			}
			
		}
	
		
		
		//delete-----------------------
		
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity delete(@PathVariable int id) {

			try {

				return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));

			} catch (Exception e) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("{\"Mi mensaje put\": \"" + e.getMessage() + "\"}");
			}

		}

	}
}