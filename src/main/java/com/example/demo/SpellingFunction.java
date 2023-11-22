package com.example.demo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import com.example.demo.Root;
import com.example.demo.Speaker;
public class SpellingFunction {
    private final Button spellingBtn;

    public SpellingFunction(Scene scene){
        String tag = "#speak";
        spellingBtn = (Button) scene.lookup(tag);
    }

    public void spellCurrentWord(Root root) {
        spellingBtn.setOnMouseClicked(e -> {
            String word = root.getCurrent();
            Speaker.speak(word);
        });
    }

}
