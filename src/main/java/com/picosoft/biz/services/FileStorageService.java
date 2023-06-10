package com.picosoft.biz.services;

import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.picosoft.biz.entities.Rapport;
import com.picosoft.biz.repository.RapportReppository;

@Service
public class FileStorageService implements IFileStorageService {
	@Autowired
	RapportReppository rapportReppository ;
	@Override
	public Rapport store(MultipartFile file) throws IOException {
		   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    Rapport FileDB = new Rapport(fileName, file.getContentType(), file.getBytes());
		    return rapportReppository.save(FileDB);
	}

	@Override
	public Rapport getFile(String id) {
		  return rapportReppository.findById(id).get();
	}

	@Override
	public Stream<Rapport> getAllFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
