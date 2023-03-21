package br.com.restapi.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restapi.forum.config.security.TokenService;
import br.com.restapi.forum.dto.LoginForm;
import br.com.restapi.forum.dto.TokenDto;

@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManage;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authenticate = authManage.authenticate(dadosLogin);	
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
