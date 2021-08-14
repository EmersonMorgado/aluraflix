package br.com.emersonmorgado.aluraflix.aluraflix.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.aluraflix.aluraflix.model.Log;
import br.com.emersonmorgado.aluraflix.aluraflix.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;
	
	void gravarLog(String titulo, String descricao) {
		Log log = new Log(titulo, descricao);
		logRepository.save(log);
	}
}
