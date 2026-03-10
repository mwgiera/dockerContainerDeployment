import requests


def fetch_data():
    response = requests.get("https://api.example.com/data", timeout=10)
    data = response.json()
    print(data["results"][0]["value"])


fetch_data()
