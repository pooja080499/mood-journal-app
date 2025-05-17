def predict_emoji(text):
    text = text.lower()
    if "happy" in text or "good" in text:
        return "😊"
    elif "sad" in text or "bad" in text:
        return "😢"
    elif "angry" in text:
        return "😡"
    else:
        return "😐"
