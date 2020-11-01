package com.smarthack.sudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * A OrderedMedicine.
 */
@Entity
@Table(name = "ordered_medicine")
public class OrderedMedicine implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 50)
    private String id;

    @Column(name = "resource_id")
    private String resourceId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JsonIgnoreProperties(value = "orderedMedicines", allowSetters = true)
    private Pharmacy pharmacy;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public OrderedMedicine resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderedMedicine quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public OrderedMedicine price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public OrderedMedicine title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public OrderedMedicine pharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
        return this;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public Order getOrder() {
        return order;
    }

    public OrderedMedicine setOrder(Order order) {
        this.order = order;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderedMedicine)) {
            return false;
        }
        return id != null && id.equals(((OrderedMedicine) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderedMedicine{" +
                "id=" + getId() +
                ", resourceId='" + getResourceId() + "'" +
                ", quantity=" + getQuantity() +
                ", price=" + getPrice() +
                ", title='" + getTitle() + "'" +
                "}";
    }
}
