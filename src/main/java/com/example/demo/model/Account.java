package com.example.demo.model;

import com.example.demo.RoleA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="role")
    private RoleA role;
    @Column(name="password")
    private String password;
    @ElementCollection
    @Column(name="devicesIds")
    private List<Long> devicesIds;

    public Account(String name, RoleA role, String password, List<Long> devicesIds) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.devicesIds = devicesIds;
    }
}
