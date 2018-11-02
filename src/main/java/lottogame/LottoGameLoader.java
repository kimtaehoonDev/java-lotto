package lottogame;

import lottogame.domain.LottoGame;
import lottogame.dto.InputDto;
import lottogame.dto.Result;
import lottogame.view.InputView;
import lottogame.view.OutputView;

import java.util.InputMismatchException;

public class LottoGameLoader {
    public static void main(String[] args) {
        try {
            InputDto inputDto = InputView.console();
            LottoGame lottoGame = new LottoGame(inputDto.getLottos());
            Result result = lottoGame.result(inputDto.getWinningLotto());
            OutputView.printResult(inputDto.readMoney(), result);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
            InputView.clearBuffer();
            main(args);
        }
    }
}