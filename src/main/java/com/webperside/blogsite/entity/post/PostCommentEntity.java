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
@Table(name = "post_comment")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PostCommentEntity extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -6983380385702960452L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id")
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_post_id", referencedColumnName = "post_id")
    private PostEntity post;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "comment")
    private String comment;

}
