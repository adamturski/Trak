package pl.com.turski.model.domain.shipment;

import pl.com.turski.model.domain.customer.Customer;
import pl.com.turski.model.domain.transport.Transport;
import pl.com.turski.model.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Adam
 */
@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ShipmentStatusEnum status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    private Customer recipient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(name = "created")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "deliverer_id")
    private User deliverer;

    @Column(name = "delivered")
    private Date delivered;

    @OneToMany(mappedBy = "shipment")
    private List<Transport> transports = new ArrayList<>();

    @OneToMany(mappedBy = "shipment")
    private List<ShipmentMovement> movements = new ArrayList<>();

    public Shipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShipmentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatusEnum status) {
        this.status = status;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(User deliverer) {
        this.deliverer = deliverer;
    }

    public Date getDelivered() {
        return delivered;
    }

    public void setDelivered(Date delivered) {
        this.delivered = delivered;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public List<ShipmentMovement> getMovements() {
        return movements;
    }
}
