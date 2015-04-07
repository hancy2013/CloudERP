package com.tutu.clouderp.api;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Service;

import com.tutu.clouderp.dto.NewsEntry;
@Service
public interface NewsEntryService {
	public String list() throws JsonGenerationException, JsonMappingException, IOException;
	public NewsEntry read(String id);
	public NewsEntry create(NewsEntry newsEntry);
	public NewsEntry update(String id, NewsEntry newsEntry);
}
