package com.webperside.blogsite.entity.dto.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class BaseDTO implements Serializable {

    private Instant createdAt;
}
