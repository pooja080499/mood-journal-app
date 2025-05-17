package com.moodjournal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moodjournal.Model.MoodEntry;
import com.moodjournal.Repository.MoodRepository;

@Service
public class MoodService {

    @Autowired
    private MoodRepository moodRepo;

    private final String AI_API_URL = "http://localhost:5000/predict"; // Flask AI model

    public MoodEntry saveMood(String mood) {
        RestTemplate restTemplate = new RestTemplate();
        String emoji = restTemplate.postForObject(AI_API_URL, mood, String.class);

        MoodEntry entry = new MoodEntry();
        entry.setMood(mood);
        entry.setEmoji(emoji);

        return moodRepo.save(entry);
    }

    public java.util.List<MoodEntry> getAllMoods() {
        return moodRepo.findAll();
    }
}