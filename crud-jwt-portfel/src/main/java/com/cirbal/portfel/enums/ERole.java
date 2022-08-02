package com.cirbal.portfel.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="erole")
public enum ERole {
	ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN
}