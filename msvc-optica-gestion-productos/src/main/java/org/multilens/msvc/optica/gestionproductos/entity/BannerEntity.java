package org.multilens.msvc.optica.gestionproductos.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "top_banner")
public class BannerEntity extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_top_banner", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "h3_tag", nullable = false)
    private String h3Tag;

    @Column(name = "p1_tag", nullable = false)
    private String p1Tag;

    @Column(name = "h4_tag", nullable = false)
    private String h4Tag;

    @Column(name = "p2_tag", nullable = false)
    private String p2Tag;

    @Column(name = "span_tag", nullable = false)
    private String spanTag;

    @Column(name = "button_tag", nullable = false)
    private String buttonTag;

    @Column(name = "img_tag", nullable = false)
    private String imgTag;


}
