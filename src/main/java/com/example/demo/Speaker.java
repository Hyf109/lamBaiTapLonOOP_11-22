package com.example.demo;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speaker {

    private static final VoiceManager voiceManager = VoiceManager.getInstance();
    private static Voice speaker = voiceManager.getVoice("kevin16");
    static {
        speaker = voiceManager.getVoice("kevin16");
        speaker.allocate();
    }
    private Speaker() {
    }

    public static void speak(String word) {
        if (speaker != null) {
            speaker.speak(word);
        }
    }

}
