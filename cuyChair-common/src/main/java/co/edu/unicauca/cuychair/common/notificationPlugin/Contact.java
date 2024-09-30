package co.edu.unicauca.cuychair.common.notificationPlugin;

public record Contact(String email, String phone) {

    public boolean hasEmail() {
        return email == null;
    }
    public boolean hasPhone() {
        return phone == null;
    }
}
