package it.cuongpq.springmvc.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    private Path root = Paths.get("uploads");

    public void saveFile(MultipartFile file) {
        //Lấy tên file
        String filename = file.getOriginalFilename();
        //Vi dụ: D:\\java\\upload  + filename
        //-> D:\\java\\upload\\tenfile.png
        try {
            Files.copy(file.getInputStream(), this.root.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Resource download(String filename) {
        Path file = this.root.resolve(filename);
        //Tạo ra thể hiện của resource từ lớp UrlResource
        try {
            Resource resource = new UrlResource(file.toUri());

            //Nếu tồn tài và sẵn sảng để đọc
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return  null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
