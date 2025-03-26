package com.cnpm.QuanLiChiTieu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Group_Members", uniqueConstraints = @UniqueConstraint(columnNames = {"group_id", "user_id"}))
@Data
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupMemberId;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.MEMBER;

    public enum Role {
        ADMIN, MEMBER
    }
}
