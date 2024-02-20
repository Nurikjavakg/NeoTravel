package neobis.travel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import neobis.travel.enums.BookingStatus;
import neobis.travel.enums.Continent;

import java.util.List;

@Entity
@Table(name = "trips")
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trips_gen")
    @SequenceGenerator(name = "trips_gen",
            sequenceName = "trips_seq",
            allocationSize = 1,
            initialValue = 1)
    private Long tripId;
    private String name;
    private String tripImage;
    private String description;
    private String place;
    @Enumerated(EnumType.STRING)
    private Continent continent;
    private boolean popular;
    private boolean mostVisited;
    private boolean featured;
    private boolean recommended;
    private String wishesToTrip;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @ManyToOne(cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE},fetch=FetchType.LAZY)
    private User reservoir;
    @OneToMany(mappedBy = "trips", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Comment> comments;
}