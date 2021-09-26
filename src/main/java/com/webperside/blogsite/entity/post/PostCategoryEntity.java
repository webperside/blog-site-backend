package com.webperside.blogsite.entity.post;

import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.entity.user.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "post_category")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PostCategoryEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5495757600022076851L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_category_id")
    private Integer id;


    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_post_id", referencedColumnName = "post_id")
    private PostEntity post;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private CategoryEntity category;
}
