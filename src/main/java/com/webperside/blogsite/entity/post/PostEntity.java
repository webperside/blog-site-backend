package com.webperside.blogsite.entity.post;

import com.webperside.blogsite.entity.base.BaseEntity;
import com.webperside.blogsite.entity.user.UserEntity;
import com.webperside.blogsite.enums.post.PostStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PostEntity extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -8799280017635445273L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "header")
    private String header;

    @Column(name = "header_photo")
    private String headerPhoto;

    @Lob
    @Column(name = "body")
    private String body;

    @Column(name = "viewed")
    private Integer viewed;

    @Enumerated
    @Column(name = "status")
    private PostStatus status;

}
