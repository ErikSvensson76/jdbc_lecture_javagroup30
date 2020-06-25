package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class AppUser {
    private int userId;
    private String username;
    private String password;
    private String fullName;
    private LocalDate birthDate;
    private boolean active;

    public AppUser(int userId, String username, String password, String fullName, LocalDate birthDate, boolean active) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.active = active;
    }

    public AppUser(String username, String password, String fullName, LocalDate birthDate) {
        this(0, username,password,fullName,birthDate, true);
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return getUserId() == appUser.getUserId() &&
                isActive() == appUser.isActive() &&
                Objects.equals(getUsername(), appUser.getUsername()) &&
                Objects.equals(getPassword(), appUser.getPassword()) &&
                Objects.equals(getFullName(), appUser.getFullName()) &&
                Objects.equals(getBirthDate(), appUser.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getPassword(), getFullName(), getBirthDate(), isActive());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                '}';
    }
}
