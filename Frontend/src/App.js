import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [moodText, setMoodText] = useState('');
  const [emoji, setEmoji] = useState('');

  const handleMoodSubmit = async () => {
    try {
      const res = await axios.post('http://localhost:5000/predict-emoji', {
        text: moodText,
      });
      setEmoji(res.data.emoji);
    } catch (err) {
      console.error('Error fetching emoji:', err);
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h2>Mood Journal with AI Emoji Suggestion</h2>
      <textarea
        rows="4"
        cols="50"
        placeholder="How are you feeling today?"
        value={moodText}
        onChange={(e) => setMoodText(e.target.value)}
      />
      <br /><br />
      <button onClick={handleMoodSubmit}>Get Emoji</button>
      {emoji && (
        <h3>Suggested Emoji: {emoji}</h3>
      )}
    </div>
  );
}

export default App;
