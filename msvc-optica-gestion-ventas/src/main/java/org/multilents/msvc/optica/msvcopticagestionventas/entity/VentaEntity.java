package org.multilents.msvc.optica.msvcopticagestionventas.entity;

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
@Table(name = "ventas")
public class VentaEntity extends AuditoriaEntity  implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_venta", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "id_producto", nullable = false)
    private UUID producto;

    @Column(name = "id_cliente", nullable = false)
    private UUID cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado_venta", nullable = false)
    private MaestroEntity estadoVenta;

    @Column(name = "cantidad", unique = true, nullable = false)
    private Double cantidad;

    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;

    private static final long serialVersionUID = 1L;

}
