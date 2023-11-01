package dev.bogdanjovanovic.models;

import java.util.List;

public record ChatCompletion(String model, List<Message> messages) {

}
