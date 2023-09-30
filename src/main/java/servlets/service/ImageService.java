package servlets.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import servlets.util.PropertiesUtil;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;
import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class ImageService {

    private static final ImageService INSTANCE = new ImageService();

    private final String basePath = PropertiesUtil.getProperties("image.base.uri");

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent) {
        Path imageFullpath = Path.of(basePath, imagePath);
        try (imageContent) {
            Files.createDirectories(imageFullpath.getParent());
            Files.write(imageFullpath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    public static ImageService getInstance() {
        return INSTANCE;
    }
}
