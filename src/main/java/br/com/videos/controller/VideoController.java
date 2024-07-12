package br.com.videos.controller;

import br.com.videos.dto.VideoInputDto;
import br.com.videos.dto.VideoResponseDto;
import br.com.videos.exception.VideoNotFoundException;
import br.com.videos.service.VideoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<VideoResponseDto> criar(@RequestBody @Valid VideoInputDto input, UriComponentsBuilder uriComponentsBuilder) {
        var video = videoService.criar(input);
        URI uri = uriComponentsBuilder.path("/videos/{id}")
                .buildAndExpand(video.id()).toUri();
        return ResponseEntity.created(uri).body(video);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponseDto> exibirPorId(@PathVariable Long id) {
        return ResponseEntity.ok(videoService.exibirPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<VideoResponseDto>> exibirTodos() {
        return ResponseEntity.ok(videoService.exibirTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponseDto> editar(@PathVariable Long id, @RequestBody VideoInputDto input) {
        return ResponseEntity.ok(videoService.editar(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try {
            videoService.excluir(id);
            return ResponseEntity.ok("Vídeo id= " + id + " excluído com sucesso");
        } catch (VideoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
