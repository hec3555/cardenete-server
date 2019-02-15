package org.cardenete.enums;

public enum RolesEnum {
	ADMIN(1), USER(2), NO_SESSION(0);
	
	public final int roleId;
	
	private RolesEnum(int roleId) {
        this.roleId = roleId;
    }
	
}
