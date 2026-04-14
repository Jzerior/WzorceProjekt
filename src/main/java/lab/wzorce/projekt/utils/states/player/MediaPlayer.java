package lab.wzorce.projekt.utils.states.player;

// Tydzień 7, Wzorzec State 2
/**
 * Kontekst maszyny stanów odtwarzacza wideo ze szkoleniami.
 */
public class MediaPlayer {
    private PlayerState state;
    private final String currentTrack;

    public MediaPlayer(String currentTrack) {
        this.currentTrack = currentTrack;
        this.state = new StoppedState(); // Domyślnie odtwarzacz jest w stanie STOP
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }

    public String getStatus() {
        return state.getStatus() + " - " + currentTrack;
    }
}
// Koniec, Tydzień 7, Wzorzec State 2