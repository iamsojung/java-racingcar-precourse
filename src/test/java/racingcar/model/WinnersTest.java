package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    PlayerGroup playerGroup;

    @BeforeEach
    void createPlayerGroup() {
        playerGroup = new PlayerGroup();
    }


    @DisplayName("최종 우승자 출력 값 확인")
    @Test
    void 최종_우승자_출력값_확인_테스트() {
        Player aaplayer = new Player(new Car(new CarName("aaplayer")));
        Player bbplayer = new Player(new Car(new CarName("bbplayer")));

        aaplayer.getCar().run(5);
        bbplayer.getCar().run(3);

        playerGroup.append(aaplayer);
        playerGroup.append(bbplayer);

        Winners winner = new Winners(playerGroup);

        String winners = "최종 우승자: red";
        assertEquals(winners, winner.toStringFinalWinnerNames());
    }
}