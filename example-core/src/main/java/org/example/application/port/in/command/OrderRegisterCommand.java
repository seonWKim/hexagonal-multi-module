package org.example.application.port.in.command;

public record OrderRegisterCommand(Long memberId, String name, int price) {}
