package br.com.videos.dto;

import jakarta.validation.constraints.NotBlank;

public record VideoInputDto(@NotBlank String titulo, @NotBlank String descricao, @NotBlank String url) {
}
