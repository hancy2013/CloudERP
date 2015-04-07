package com.tutu.clouderp.api;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Service;

import com.tutu.clouderp.dto.auth.MM;
@Service
public interface MMService {
	public MM create(MM mm);
	public List<MM> list() throws JsonGenerationException, JsonMappingException, IOException;
}
