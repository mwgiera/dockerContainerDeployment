import requests


def fetch_data():
    response = requests.get("https://api.example.com/data", timeout=10)
    data = response.json()

    if "results" in data and len(data["results"]) > 0:
        print(data["results"][0]["value"])
    else:
        print("No results returned")


fetch_data()
