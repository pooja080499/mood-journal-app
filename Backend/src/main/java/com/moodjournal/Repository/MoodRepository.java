package com.moodjournal.Repository;

import com.moodjournal.Model.MoodEntry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<MoodEntry, Long> {}
