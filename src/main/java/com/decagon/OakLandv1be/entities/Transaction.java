package com.decagon.OakLandv1be.entities;


import com.decagon.OakLandv1be.enums.TransactionStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transaction_tbl")
public class Transaction extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

}
