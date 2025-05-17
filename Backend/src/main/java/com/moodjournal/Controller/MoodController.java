package com.moodjournal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moodjournal.Model.MoodEntry;
import com.moodjournal.Service.MoodService;

@RestController
@RequestMapping("/api/moods")
@CrossOrigin(origins = "*")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @PostMapping
    public MoodEntry addMood(@RequestBody String mood) {
        return moodService.saveMood(mood);
    }

    @GetMapping
    public List<MoodEntry> getMoods() {
        return moodService.getAllMoods();
    }
}