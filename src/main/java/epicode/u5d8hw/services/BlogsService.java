package epicode.u5d8hw.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class BlogsService {
    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    


    public String uploadCover(int blogId, MultipartFile file) {
        try {
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret));
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("secure_url");

            Blogpost blogpost = findById(blogId);
            blogpost.setCover(imageUrl);
            blogsRepository.save(blogpost);
            return imageUrl;
        } catch (IOException e) {

            e.printStackTrace();
            throw new RuntimeException("Errore durante il caricamento dell'immagine");
        }
    }
}
