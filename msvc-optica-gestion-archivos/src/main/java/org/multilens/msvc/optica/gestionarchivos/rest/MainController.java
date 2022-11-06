package org.multilens.msvc.optica.gestionarchivos.rest;

import lombok.extern.slf4j.Slf4j;
import org.multilens.msvc.optica.gestionarchivos.exception.NotFoundException;
import org.multilens.msvc.optica.gestionarchivos.service.Impl.CloudinaryService;
import org.multilens.msvc.optica.gestionarchivos.utils.CodeEnum;
import org.multilens.msvc.optica.gestionarchivos.utils.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/cloudinary")
public class MainController {

    private final CloudinaryService cloudinaryService;

    public MainController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public ResponseEntity<CustomResponse> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            throw new NotFoundException("imagen no válida");
        }
        Map result = cloudinaryService.upload(multipartFile);

        CustomResponse rpta = new CustomResponse(String.valueOf(CodeEnum.SUCCESS), "imagen subida");
        return new ResponseEntity<>(rpta, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id)throws IOException {
        Map result = cloudinaryService.delete(id);
        CustomResponse rpta = new CustomResponse(Boolean.TRUE.equals(result)?"1":"0", Boolean.TRUE.equals(result) ? "imagen eliminada":"Error al eliminar");
        return new ResponseEntity<>(rpta, HttpStatus.OK);

    }
}
