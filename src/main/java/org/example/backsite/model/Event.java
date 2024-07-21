package org.example.backsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@Entity
public class Event extends BaseModel{
    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("place")
    @Column(name = "place")
    private String place;

    @JsonProperty("date")
    @Column(name = "date")
    private String date;

}
