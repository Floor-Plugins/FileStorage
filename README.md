# FileStorage

**FileStorage** is a lightweight and fun Minecraft Paper plugin that uses wool blocks to store UTF-8 text data inside chunks. Perfect for creative data storage experiments or just to mess around and see what happens when you change one block in a hidden structure.

- 💾 Stores UTF-8 data using all 16 wool colors  
- 🌎 Saves data in the currently-selected chunk at Y level -60  
- 🎮 Interact via in-game commands  
- 🧪 Great for superflat testing or hidden use in regular worlds

---

## 📦 Features

- **Chunk Selection**:  
  `/fsselect` — Selects the chunk the player is currently standing in.

- **Write Data**:  
  `/fswrite <offset> <text>` — Writes UTF-8 text starting at the given byte offset. Returns the number of bytes written.

- **Read Data**:  
  `/fsread <offset> <length>` — Reads a given number of bytes starting from an offset. Displays the decoded string.

- Data is saved at **Y = -60**, deep underground to avoid interference and remain hidden.

---

## 🧠 Why?

This plugin doesn’t serve a practical gameplay function—its goal is to encourage exploration of how data can be encoded using Minecraft blocks. Want to see what happens when you remove one wool block from your data string? This plugin is for you.

---

## 🛠️ Getting Started

1. **Install** the plugin into your PaperMC `plugins/` folder.  
2. **Restart** the server or reload with `/reload`.  
3. **Use the Commands** to interact with the selected chunk.

---

## 🔧 Configuration

File: `config.yml`  
Basic plugin config settings (if any). Defaults are sufficient for most use cases.

---

## 📂 Project Structure

'''
FileStorage/
├── src/main/java/com/floorplugins/filestorage/
│   ├── commands/
│   │   ├── FSReadCommand.java
│   │   ├── FSReloadCommand.java
│   │   ├── FSSelectCommand.java
│   │   └── FSWriteCommand.java
│   ├── util/
│   │   └── HexUtils.java
│   ├── HexChunk.java
│   ├── Plugin.java
│   └── Responder.java
├── src/main/resources/
│   ├── plugin.yml
│   └── config.yml
├── pom.xml
├── LICENSE
└── README.md
'''

---

## 🤝 Contributing

Contributions are welcome! If you’d like to improve FileStorage, fix a bug, or add a feature:

1. Fork the repo  
2. Create a new branch: `git checkout -b my-feature`  
3. Make your changes  
4. Open a Pull Request  

Please write clear commit messages and follow the structure used in existing files. Keep the plugin fun and lightweight!

---

## 📜 License

This project is licensed under the [MIT License](./LICENSE). You are free to use, modify, and distribute this plugin.

---

## 💬 Need Help?

If you run into issues or have a question:

- Open an Issue on GitHub  
- Contact the creator (if applicable)  
- Or just experiment! That’s half the fun.

---

Made with ❤️ by **Floor Plugins**
