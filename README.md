**ChatApp**
---
Chat Server in Java
A simple multi-client chat server written in Java. This server allows multiple clients to connect, exchange messages in real-time, and see messages from other users. Each client can set their own nickname, and the server broadcasts messages to all connected clients.
---
Features
-Multi-client support: Handles multiple clients simultaneously using threads.

-Nicknames: Clients can set their own nicknames to personalize messages.

-Real-time messaging: Messages are broadcast to all connected clients instantly.

-Simple and lightweight: Built using Java's java.net library.
 ---
How It Works
-The server listens for incoming client connections on a specified port.

-Each client connects to the server and provides a nickname.

-Clients can send messages, which are broadcast to all other connected clients with the sender's nickname.

-The server handles client disconnections gracefully and notifies other users.
---
Technologies
Java: Core language for server and client implementation.

Java Networking: Uses ServerSocket and Socket for communication.

Multithreading: Each client is handled in a separate thread for concurrent communication.
---
