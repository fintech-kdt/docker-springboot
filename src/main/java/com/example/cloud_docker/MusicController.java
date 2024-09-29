package com.example.cloud_docker;

import com.example.cloud_docker.model.Music;
import com.example.cloud_docker.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/musics")
@CrossOrigin(originPatterns = "*")
public class MusicController {
    private final MusicRepository musicRepository;

    @GetMapping
    public ResponseEntity<List<Music>> getMusics() {
        return ResponseEntity.ok(musicRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicRepository.save(music));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable Long id) {
        return ResponseEntity.ok(musicRepository.findById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public Music updateMusic(@PathVariable Long id, @RequestBody Music music) {
        Music oldMusic = musicRepository.findById(id).orElseThrow();
        music.setId(oldMusic.getId());
        return musicRepository.save(music);
    }

    @DeleteMapping("/{id}")
    public void deleteMusic(@PathVariable Long id) {
        musicRepository.findById(id).orElseThrow();
        musicRepository.deleteById(id);
    }
}
