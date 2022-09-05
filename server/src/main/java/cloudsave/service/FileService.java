package cloudsave.service;

import cloudsave.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
    Result saveFile(MultipartFile file);

    void downloadFile(String filename, HttpServletResponse response);
}
