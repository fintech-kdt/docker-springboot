package com.example.cloud_docker.repository;

import com.example.cloud_docker.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
