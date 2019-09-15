package pl.sda.shop.model;

public enum UserRole {
    ADMIN(3),REGULAR(2),ANONYMOUS(1);

    private int level;

    UserRole(int level) {

        this.level = level;
    }

    boolean ensures(UserRole userRole){
        return level >= userRole.level;
    }
}
