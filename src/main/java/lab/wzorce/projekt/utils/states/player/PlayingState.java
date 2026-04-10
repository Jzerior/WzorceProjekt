package lab.wzorce.projekt.utils.states.player;

// Tydzień 7, Wzorzec State 2
public class PlayingState implements PlayerState {
    @Override
    public void play(MediaPlayer context) {
        System.out.println("BŁĄD: Wideo jest już odtwarzane.");
    }

    @Override
    public void pause(MediaPlayer context) {
        System.out.println("Wideo zapauzowane.");
        context.setState(new PausedState()); // Zmiana stanu
    }

    @Override
    public void stop(MediaPlayer context) {
        System.out.println("Zatrzymywanie wideo.");
        context.setState(new StoppedState()); // Zmiana stanu
    }

    @Override
    public String getStatus() {
        return "ODTWARZANIE (PLAY)";
    }
}
// Koniec, Tydzień 7, Wzorzec State 2