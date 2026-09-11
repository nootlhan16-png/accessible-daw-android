# Accessible Digital Audio Workstation (DAW)

A simple, accessible Digital Audio Workstation application for Android devices.

## Features

✅ **Audio Recording** - Record high-quality audio from your device's microphone
✅ **Playback** - Play back your recordings with a single tap
✅ **Accessible UI** - Large buttons with content descriptions for screen readers
✅ **Simple Interface** - Easy-to-use controls for everyone
✅ **Automated Build** - GitHub Actions automatically builds the app

## Requirements

- Android 5.1 (API 21) or higher
- Microphone permission
- Storage permission

## Installation

1. Clone this repository:
```bash
git clone https://github.com/nootlhan16-png/accessible-daw-android.git
cd accessible-daw-android
```

2. Build the app:
```bash
./gradlew build
```

3. Install on your device:
```bash
./gradlew installDebug
```

## Usage

1. **Record**: Tap the "🔴 Record" button to start recording audio
2. **Stop**: Tap the "⏹️ Stop" button to stop recording
3. **Play**: Tap the "▶️ Play" button to play the recorded audio

## Project Structure

```
accessible-daw-android/
├── MainActivity.kt           # Main activity with recording/playback logic
├── activity_main.xml         # UI layout file
├── AndroidManifest.xml       # App manifest and permissions
├── build.gradle              # Gradle build configuration
└── .github/workflows/        # GitHub Actions workflows
    └── build.yml             # Automated build pipeline
```

## Accessibility Features

- Large, easy-to-tap buttons
- Content descriptions for all UI elements
- High contrast text
- Screen reader compatible

## Development

### Building from Source

```bash
# Build the debug APK
./gradlew assembleDebug

# Build the release APK
./gradlew assembleRelease

# Run tests
./gradlew test
```

### Technologies Used

- Kotlin
- Android MediaRecorder API
- Android MediaPlayer API
- AndroidX libraries

## Permissions

The app requires the following permissions:
- `RECORD_AUDIO` - To record audio from the microphone
- `WRITE_EXTERNAL_STORAGE` - To save recordings
- `READ_EXTERNAL_STORAGE` - To read recordings

## License

MIT License - feel free to use this project for personal or commercial purposes.

## Support

For issues or feature requests, please create an issue on GitHub.

---

**Built with ❤️ for accessibility**