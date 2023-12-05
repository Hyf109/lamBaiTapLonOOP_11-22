package com.example.demo;
public class Start {
    public static void main(String[] args){
        System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        DictionaryApp.main(args);
    }
}

