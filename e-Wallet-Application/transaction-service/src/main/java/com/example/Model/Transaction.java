package com.example.Model;


import jakarta.persistence.*;
import jakarta.validation.groups.Default;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String externalId;

    private String senderId;

    private String receiverId;

    private long amount; //IN LOWEST DENOMINATION

    private String reason;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

}

