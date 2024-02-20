package ru.skillbox.currency.exchange.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SQLInsert(sql = "INSERT INTO currency (iso_char_code, iso_num_code, name, nominal, value, id) values (?, ?, ?, ?, ?, ?) " +
        "ON CONFLICT(iso_char_code) DO UPDATE SET iso_num_code = EXCLUDED.iso_num_code, name = EXCLUDED.name, nominal = EXCLUDED.nominal, value = EXCLUDED.value")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "create_sequence", allocationSize = 0)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nominal")
    private Long nominal;

    @Column(name = "value")
    private Double value;

    @Column(name = "iso_num_code")
    private Long isoNumCode;

    @Column(name = "iso_char_code", unique = true)
    private String isoCharCode;
}
