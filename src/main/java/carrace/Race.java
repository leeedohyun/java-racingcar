package carrace;


import carrace.ui.InputView;
import carrace.ui.ResultView;

public class Race {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        CarRace carRace = inputView.makeCarRaceByInput();
        ResultView resultView = new ResultView();

        System.out.println("\n실행 결과");
        for (int i = 0; i < carRace.getNumberOfRaces(); i++) {
            carRace.startEachRace();
            resultView.printCarRace(carRace);
        }
        carRace.endRace();
        resultView.printWinners(carRace);
    }
}