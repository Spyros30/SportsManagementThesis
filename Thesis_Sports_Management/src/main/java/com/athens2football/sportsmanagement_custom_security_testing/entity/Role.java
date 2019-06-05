package com.athens2football.sportsmanagement_custom_security_testing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
}
