package cloudsave.controller;

import cloudsave.result.Result;
import cloudsave.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@RestController
@RequestMapping("/file")
public class FileController {
    private String defaultPath;
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        return fileService.saveFile(file);
    }

    @GetMapping(value = "/download")
    public void testDownload(String filename, HttpServletResponse response) {
        fileService.downloadFile(filename, response);
    }

}
