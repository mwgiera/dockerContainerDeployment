import os
from http.server import HTTPServer, SimpleHTTPRequestHandler

PORT = int(os.getenv("PORT", "5000"))
server = HTTPServer(("0.0.0.0", PORT), SimpleHTTPRequestHandler)
print(f"Server starting on port {PORT}")
server.serve_forever()
