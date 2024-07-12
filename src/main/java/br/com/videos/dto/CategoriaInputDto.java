package br.com.videos.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link br.com.videos.model.Categoria}
 */
public record CategoriaInputDto(@NotBlank String titulo, @NotBlank String cor) implements Serializable {
}