package com.webperside.blogsite.entity.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -6041925771909432938L;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

}
