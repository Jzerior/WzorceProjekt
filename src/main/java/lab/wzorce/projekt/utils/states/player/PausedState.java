package lab.wzorce.projekt.utils.states.player;

// Tydzień 7, Wzorzec State 2
public class PausedState implements PlayerState {
    @Override
    public void play(MediaPlayer context) {
        System.out.println("Wznawianie odtwarzania wideo...");
        context.setState(new PlayingState()); // Zmiana stanu
    }

    @Override
    public void pause(MediaPlayer context) {
        System.out.println("BŁĄD: Wideo jest już zapauzowane.");
    }

    @Override
    public void stop(MediaPlayer context) {
        System.out.println("Zatrzymywanie wideo z trybu pauzy.");
        context.setState(new StoppedState()); // Zmiana stanu
    }

    @Override
    public String getStatus() {
        return "ZAPAUZOWANY (PAUSE)";
    }
}
// Koniec, Tydzień 7, Wzorzec State 2