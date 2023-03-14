package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private String name;
    private String announcement;
    private  int type;
    private boolean showAnnouncement;
    private boolean deleted;
    private int id;
    private String error;
}
