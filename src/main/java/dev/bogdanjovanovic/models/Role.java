package dev.bogdanjovanovic.models;

public enum Role {
  SYSTEM("system"),
  USER("user"),
  ASSISTANT("assistant");

  private final String role;

  Role(final String role) {
    this.role = role;
  }

  public String getRole() {
    return this.role;
  }
}
