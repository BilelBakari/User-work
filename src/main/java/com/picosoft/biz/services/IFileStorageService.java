package com.picosoft.biz.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.picosoft.biz.entities.Rapport;


public interface IFileStorageService {
	public Rapport store(MultipartFile file) throws IOException;
	public Rapport getFile(String id);
	public Stream<Rapport> getAllFiles(); 
}
