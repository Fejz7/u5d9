package epicode.u5d8hw.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class NewBlogPostPayload {
    @NotNull
    private int authorId;

    @NotBlank
    private String category;

    @NotBlank
    private String content;

    @NotNull
    private double readingTime;

    @NotBlank
    @Size(max = 100)
    private String title;

    // Getter e setter
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(double readingTime) {
        this.readingTime = readingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
