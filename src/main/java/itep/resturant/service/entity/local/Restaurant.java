package itep.resturant.service.entity.local;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
public class Restaurant{

    public Restaurant() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    @NotNull
    public String name;
    public String description;
    public String location;
    @Column(unique = true)
    public String email;
    public byte[] logo;
    @Column(unique = true)
    public String phone;
    @Column(unique = true)
    public int mobile;
    public String latitude;
    public String longitude;
    public String tag;
    public boolean isOnline;
    @NotNull(message ="CreatedBy is required" )
    public LocalTime openingAt;
    public LocalTime closingAt;
    @NotNull(message ="CreatedBy is required" )
    public long createdBy;
    public long updatedBy;
    @NotNull(message ="CreatedBy is required" )
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.PERSIST)
    private Set<Menu> menus;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.PERSIST)
    private Set<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cuisine_id", nullable=false)
    private Cuisine cuisine;

}
