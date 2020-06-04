package lotto;

import lotto.domain.LottoBill;
import lotto.domain.LottoMachine;
import lotto.domain.ticket.LottoWinningTicket;
import lotto.domain.vo.LottoMoney;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        int numberOfManualTicket = InputView.inputNumberOfManualTicket();

        LottoMoney lottoMoney = new LottoMoney(purchaseAmount, numberOfManualTicket);

        OutputView.printNumberOfTicket(lottoMoney);

        LottoBill lottoBill = LottoMachine.purchaseLottoTicket(lottoMoney.getNumberOfAutoTicket());

        OutputView.printLottoTickets(lottoBill.getAllTickets());

        List<Integer> winningNumbers = InputView.inputLastWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoBill.drawAllLotto(lottoWinningTicket);

        OutputView.printWinningStatistics(lottoResult, lottoMoney);
    }
}
