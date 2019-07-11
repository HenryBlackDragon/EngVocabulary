package com.alex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@ToString(of = {"id", "engName", "ruName"})
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Word {
    private Long id;
    private String engName;
    private String ruName;
}
