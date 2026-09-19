package com.dddmoduleseparation.member;

import com.dddmoduleseparation.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseIdAndTime {

    @Column(unique = true)
    private String username;

    private String password;

    private String ninkname;
}
