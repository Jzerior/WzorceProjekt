package lab.wzorce.projekt.utils.states.player;

// Tydzień 7, Wzorzec State 2
/**
 * Interfejs stanu dla odtwarzacza multimedialnego.
 * Każdy stan implementuje reakcje na wciśnięcie głównych przycisków odtwarzacza.
 */
public interface PlayerState {
    void play(MediaPlayer context);
    void pause(MediaPlayer context);
    void stop(MediaPlayer context);
    String getStatus();
}
// Koniec, Tydzień 7, Wzorzec State 2