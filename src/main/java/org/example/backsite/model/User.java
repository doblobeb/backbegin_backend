package org.example.backsite.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseModel{

    @JsonProperty("name")
    @Column(name = "user_name")
    private String name;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;


    @JsonProperty("password")
    @Column(name = "password")
    private String password;

    @OneToMany
    private List<Event> event;

    public void setEventsToList(Event events) {
        this.event.add(events);
    }








}
