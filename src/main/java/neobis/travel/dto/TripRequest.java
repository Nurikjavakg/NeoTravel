package neobis.travel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class TripRequest {
    private String name;
    private String tripImage;
    private String description;
    private String place;
    private boolean popular;
    private boolean mostVisited;
    private boolean featured;

    public TripRequest(String name, String tripImage, String description, String place, boolean popular, boolean mostVisited, boolean featured) {
        this.name = name;
        this.tripImage = tripImage;
        this.description = description;
        this.place = place;
        this.popular = popular;
        this.mostVisited = mostVisited;
        this.featured = featured;
    }

    public TripRequest(boolean featured) {
        this.featured = featured;
    }
}