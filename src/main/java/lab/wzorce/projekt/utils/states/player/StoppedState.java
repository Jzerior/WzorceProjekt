package lab.wzorce.projekt.utils.states.player;

// Tydzień 7, Wzorzec State 2
public class StoppedState implements PlayerState {
    @Override
    public void play(MediaPlayer context) {
        System.out.println("Rozpoczynam odtwarzanie wideo...");
        context.setState(new PlayingState()); // Zmiana stanu
    }

    @Override
    public void pause(MediaPlayer context) {
        System.out.println("BŁĄD: Nie można zapauzować wideo, które jest zatrzymane.");
    }

    @Override
    public void stop(MediaPlayer context) {
        System.out.println("BŁĄD: Odtwarzacz jest już zatrzymany.");
    }

    @Override
    public String getStatus() {
        return "ZATRZYMANY (STOP)";
    }
}
// Koniec, Tydzień 7, Wzorzec State 2