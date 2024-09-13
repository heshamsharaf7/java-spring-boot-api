package itep.resturant.service.entity.local;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "")
    public String name;
    public String description;
    public long createdBy;
    public long updatedBy;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    @OneToMany(mappedBy = "cuisine",cascade = CascadeType.PERSIST)
    private Set<Restaurant> restaurants;

    public Cuisine() {

    }


}
