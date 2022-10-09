package racingcar.model;

public class Winners {
    PlayerGroup winnerGroup;
    Distance distance;

    public static final String WINNER_SEPARATOR = ", ";
    public static final String WINNER_NOTICE_STR = "최종 우승자: ";

    public Winners(PlayerGroup group) {
        winnerGroup = new PlayerGroup();
        distance = new Distance();

        for (Player racer : group.getPlayerGroup()) {
            setWinnerGroup(racer);
        }
    }

    private void setWinnerGroup(Player racer) {
        int compared = racer.getCar().getDistance().compareTo(distance);
        int equal = 0;

        if (compared > equal) {
            winnerGroup.reset();
        }

        if (compared >= equal) {
            winnerGroup.append(racer);
            this.distance = racer.getCar().getDistance();
        }
    }

    public String toStringFinalWinnerNames() {
        StringBuilder winners = new StringBuilder();

        for (Player player : winnerGroup.getPlayerGroup()) {
            winners.append(player.getCar().getCarName());
            winners.append(WINNER_SEPARATOR);
        }

        return WINNER_NOTICE_STR + winners.substring(0, winners.length() -2);
    }
}