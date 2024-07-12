package br.com.videos.dto;

import java.io.Serializable;

/**
 * DTO for {@link br.com.videos.model.Categoria}
 */
public record CategoriaResponseDto(Long id, String titulo, String cor) implements Serializable {
}