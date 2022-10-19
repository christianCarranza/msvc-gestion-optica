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
@Table(name = "horizontal_slider")
public class SliderEntity  extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_horizontal_slider", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "h4_tag", nullable = false)
    private String h4Tag;

    @Column(name = "h3_1_tag", nullable = false)
    private String h31Tag;

    @Column(name = "h3_2_tag", nullable = false)
    private String h32Tag;

    @Column(name = "h3_3_tag", nullable = false)
    private String h33Tag;

    @Column(name = "h3_4s_tag", nullable = false)
    private String h34sTag;

    @Column(name = "button_tag", nullable = false)
    private String buttonTag;

    @Column(name = "img_tag", nullable = false)
    private String imgTag;


}
