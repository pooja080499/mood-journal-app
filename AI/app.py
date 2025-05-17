from flask import Flask, request, jsonify
from flask_cors import CORS
from emoji_predictor import predict_emoji

app = Flask(__name__)
CORS(app)

@app.route("/predict-emoji", methods=["POST"])
def predict():
    data = request.get_json()
    text = data.get("text", "")
    print("Received text:", text)
    emoji = predict_emoji(text)
    return jsonify({"emoji": emoji})

if __name__ == "__main__":
    app.run(debug=True)
