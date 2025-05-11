package com.example.cloudproject.Client.domain;

import com.example.cloudproject.Payment.domain.Payment;
import com.example.cloudproject.Plan.domain.Plan;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    private String imagenUrlKey;

    @ManyToOne(fetch = FetchType.LAZY) // Relación Many-to-One con Plan
    @JoinColumn(name = "id_plan", nullable = false)
    private Plan plan;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true) // 'client' es el nombre del campo en la clase Payment
    private List<Payment> payments = new ArrayList<>();
}
