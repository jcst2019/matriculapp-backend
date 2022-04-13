package com.iep.triunfo.matriculappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.LocalDateTime;

@Schema(description = "Información del Detalle del Cronograma")
@Entity
@Table(name = "submenu")
public class SubMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubmenu;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false, foreignKey = @ForeignKey(name = "fk_menu_submenu"))
    private Menu menu;

    @Column(name = "nombre", nullable = false)
    private String label;

    @Column(name = "url", nullable = false)
    private String link;

    @Column(name = "icono", nullable = false)
    private String icon;

    public Integer getIdSubmenu() {
        return idSubmenu;
    }

    public void setIdSubmenu(Integer idSubmenu) {
        this.idSubmenu = idSubmenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
