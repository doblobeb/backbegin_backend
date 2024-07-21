package org.example.backsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 5190598237215532904L;

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("created_at")
    @Column(name = "created_at")
    private String createdAt = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
}