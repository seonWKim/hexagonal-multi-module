package org.example.api.member;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record MemberRequest(
        @Length(min = 1, max = 255)
        String name,
        @Min(0)
        @Max(200) int age) {}
